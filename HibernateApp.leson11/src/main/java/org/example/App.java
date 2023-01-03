package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println("Получили человека");


            session.getTransaction().commit();
            //session.close()
            System.out.println("Сессия закончилась (session.close())");


            // Открываем сессию и транзакцию еще раз (в любом другом месте в коде)
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Внутри второй транзакции");

            person = (Person) session.merge(person);

//            Hibernate.initialize(person.getItems());

            List<Item> items = session.createQuery("select i from Item i where i.owner.id=:personId", Item.class)
                    .setParameter("personId", person.getId()).getResultList();

            System.out.println(items);

            session.getTransaction().commit();

            System.out.println("Вне второй сессии");

//            System.out.println(person.getItems());
        } finally {
            sessionFactory.close();
        }
    }
}
