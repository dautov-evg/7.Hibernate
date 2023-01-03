package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

////            Получаем человека с id = 3
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
////            Выводим список товаров у id = 3 (работает только внутри транзакции)
//            List<Item> items = person.getItems();
//            System.out.println(items);

////            Получаем товар с id = 5
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
////            Вывод владельца этого товара
//            Person person = item.getOwner();
//            System.out.println(person);


////            Добавление нового товара для человека с id = 2
//            Person person = session.get(Person.class, 2);
////            Добавляем новый товар, который принадлежит person (person.id = 2)
//            Item newItem = new Item("Item from Hibernate", person);
////            Hibernate кэширует таблицы, чтобы товары корректно указывались, это необходимо сделать
//            person.getItems().add(newItem);
//            session.save(newItem);


////            Создание нового человека с одним заказом
//            Person person = new Person("Hibernate person", 22);
//            Item newItem = new Item("Item from Hibernate 2", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//
//            session.save(person);
//            session.save(newItem);


////            Удаление товаров у человека с id = 3
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//
//            for (Item item : items) {
//                session.remove(item);
//            }
//
//            person.getItems().clear();


////            Удаление человека с id = 2
//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//
//            person.getItems().forEach(i -> i.setOwner(null));


////            Замена владельца у существующего товара
//            Person person = session.get(Person.class, 4);
//            Item item = session.get(Item.class, 1);
////            Удаление списка товаров у старого владельца
//            item.getOwner().getItems().remove(item);
////            Устанавливаем новое значение для товара в колонке person_id
////            SQL - запрос
//            item.setOwner(person);
//            person.getItems().add(item);




            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
