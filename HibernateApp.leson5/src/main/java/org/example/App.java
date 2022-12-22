package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // Обновление имени у сущности с id=2
//            Person person = session.get(Person.class, 2);
//            person.setName("New name");

//            Удаление сущности с id=2
//            Person person = session.get(Person.class, 2);
//            session.delete(person);

            Person person = new Person("Some name", 60);
            session.save(person);


            session.getTransaction().commit();

            System.out.println(person.getId());
        } finally {
            sessionFactory.close();
        }
    }
}
