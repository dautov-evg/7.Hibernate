package org.example;

import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//            создаем нового челоека и новый паспорт
            Person person = new Person("Test person", 25);
            Passport passport = new Passport(person,12345);
//            устанавливаем связь с двух сторон чтобы в кэш Hibernate была правильная информация
            person.setPassport(passport);
//            сохраняем в БД
            session.save(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
