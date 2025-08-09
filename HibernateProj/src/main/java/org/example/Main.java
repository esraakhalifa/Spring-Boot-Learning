package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
//        Laptop l1 = new Laptop();
//        l1.setId(1);
//        l1.setBrand("Asus");
//        l1.setModel("Rog");
//        l1.setRam(16);
//
//        Laptop l2 = new Laptop();
//        l1.setId(2);
//        l2.setBrand("Dell");
//        l2.setModel("G3");
//        l2.setRam(64);
//
//        Student s1 = new Student();
//        s1.setsName("Salma");
//        s1.setRollNo(176);
//        s1.setsAge(10);

//        s1.setLaptops(Arrays.asList(l1,l2));


        // Proper Hibernate configuration
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")       // ✅ Loads config
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)// ✅ Maps the entity
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

//        session.persist(l1);
//        session.persist(l2);
//        session.persist(s1);
            Student s2 = session.find(Student.class,176);
            Laptop l1 = session.find(Laptop.class, 0);
            Laptop l2 = session.find(Laptop.class, 2);
            l1.setStudent(s2);
            l2.setStudent(s2);
            session.persist(l1);
            session.persist(l2);
            session.getTransaction().commit();
            System.out.println("Saved: " + s2);

        } finally {
            session.close();
            sessionFactory.close();
        }




        // Fetching data from the database using Hibernate


    }
}
