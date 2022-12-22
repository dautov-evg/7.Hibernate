package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Вывод списка всех людей из БД в консоль
//            List<Person> people = session.createQuery("FROM Person").getResultList();
//            for (Person person : people) {
//                System.out.println(person);
//            }

//            Вывод списка всех людей, чей возраст > 30
//            List<Person> people = session.createQuery("FROM Person WHERE age > 30").getResultList();
//            for (Person person : people) {
//                System.out.println(person);
//            }

//            Вывод всех людей, чье имя начинается на 'T'
//            List<Person> people = session.createQuery("FROM Person WHERE name LIKE 'T%'").getResultList();
//            for (Person person : people) {
//                System.out.println(person);
//            }


//            Обновить имена людей чей возраст < 30 на имя "Test"
//            session.createQuery("UPDATE Person SET name='Test' WHERE age < 30").executeUpdate();


//            Удалить людей, чей возраст < 30
            session.createQuery("DELETE FROM Person WHERE age < 30").executeUpdate();


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
