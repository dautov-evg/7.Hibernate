package org.example;


import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

////            2. Получаем директора, а через него получаем школу
//            Principal principal = session.get(Principal.class, 1);
//            System.out.println(principal);
//            System.out.println(principal.getSchool());

////            3. Получаем школу, а через нее директора
//            School school = session.get(School.class, 1);
//            System.out.println(school);
//            System.out.println(school.getPrincipal());

////            4. Создаие нового директора и новой школы
//            Principal principal = new Principal("Test principal", 99);
//            School school = new School(12345);
////            устанавливаем связь с двух сторон чтобы в кэш Hibernate была правильная информация
//            principal.setSchool(school);
////            сохраняем в БД
//            session.save(principal);

//            5. Смена директора у существующей школы
            School school = session.get(School.class, 8);
            Principal principal = session.get(Principal.class, 4);
            principal.setSchool(school);

            session.save(principal);




////            Изменение номера паспорта у человека
//            Person person = session.get(Person.class,1);
//            person.getPassport().setPassportNumber(77777);

////            Удаление человека и проверка каскадного удаления паспорта
//            Person person = session.get(Person.class, 1);
//            session.remove(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
