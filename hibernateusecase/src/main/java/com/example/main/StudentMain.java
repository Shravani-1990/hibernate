package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.Student;
import com.example.util.HibernateUtil;

public class StudentMain {
    public static void main(String[] args) {
        // Initialize Hibernate session
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // ✅ Creating Student objects
            Student student1 = new Student("John Doe", 101);
            Student student2 = new Student("Alice Smith", 102);

            // ✅ Persist students (use persist() for Hibernate 5+)
            session.persist(student1);
            session.persist(student2);

            // ✅ Commit transaction
            transaction.commit();

            System.out.println("✅ Students inserted successfully!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
