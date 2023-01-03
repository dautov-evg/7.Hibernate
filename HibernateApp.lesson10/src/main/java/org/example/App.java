package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

////            Добавление нового фильма и у него 2 актера
//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor1 = new Actor("Harvey Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);

////            Вывести список актеров для фильма
//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());

//            Добавление нового фильма и связывание его с существующим актером
//            Movie movie = new Movie("Reservior Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//
//            session.save(movie);

//            Удаление фильма у существующего актера
            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());

            Movie moveToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(0);
            moveToRemove.getActors().remove(actor); // для реализации необходим hashcode и equals

            session.getTransaction().commit();
        }
    }
}
