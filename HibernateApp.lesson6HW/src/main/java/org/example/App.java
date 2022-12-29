package org.example;


import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

////            Задание 2 (получение любого режиссера, а затем список его фильмов)
//            Director director = session.get(Director.class, 3);
//            System.out.println(director);
//            List<Movie> movies = director.getMovies();
//            System.out.println(movies);

////            Задание 3 (получить любой фильм, а затем его режиссера)
//            Movie movie = session.get(Movie.class, 5);
//            System.out.println(movie);
//            Director director = movie.getOwner();
//            System.out.println(director);

////            Задание 4 (Добавьте еще один фильм для любого режиссера)
//            Director director = session.get(Director.class, 3);
//            Movie newMovie = new Movie("Hiber1", 2022, director);
//            director.getMovies().add(newMovie);
//            session.save(newMovie);

////            Задание 5 (Создайте нового режиссера и новый фильм и свяжите эти сущности)
//            Director director = new Director("DirHib", 20);
//            Movie newMovie = new Movie("hiber5", 2000, director);
//            director.setMovies(new ArrayList<>(Collections.singletonList(newMovie)));
//            session.save(director);
//            session.save(newMovie);

////            Задание 6 (Смените режиссера у существующего фильма)
//            Director director = session.get(Director.class, 1);
//            Movie movie = session.get(Movie.class, 8);
//            movie.getOwner().getMovies().remove(movie);
//            movie.setOwner(director);
//            director.getMovies().add(movie);

////            Задание 7 (Удалите фильм у любого режиссера)
//            Director director = session.get(Director.class, 7);
//            Movie movie = director.getMovies().get(0);
//            director.getMovies().remove(movie);
//            session.remove(movie);




            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
