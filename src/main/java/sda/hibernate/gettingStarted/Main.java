package sda.hibernate.gettingStarted;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.utils.DateUtils;
import sda.hibernate.utils.HibernateUtils;

import java.time.LocalDateTime;

public class Main {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     *
     * [READ]
     * Use session object to fetch a UserEntity from database by id using 'find' method and print to console. Close session.
     *
     * [UPDATE]
     * Set another age to fetched UserEntity and commit transaction, close session. Check user in database. What is changed?
     *
     * [INSERT]
     * Create a new UserEntity (set a name, age and createdAt using DateUtils.now()) and insert in database using session instance (methods 'persist' or 'merge').
     * After calling 'persist' method, print user to console. What do you observe? Commit transaction and close session.
     *
     * [DELETE]
     * Fetch a UserEntity from database and delete it using 'remove' method on session instance. Check in database.
     *
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<UserEntity> query = session.createQuery("select u from UserEntity u where u.name = 'Andrei'", UserEntity.class);
        UserEntity andrei = query.getSingleResult();
        System.out.println(andrei);
        session.remove(andrei);
        System.out.println(andrei);

        transaction.commit();
        session.close();
    }
    public static void mainInsert(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserEntity ana = new UserEntity();
        ana.setName("Ana");
        ana.setAge(28);
        ana.setCreatedAt(LocalDateTime.now());
        session.persist(ana);
        System.out.println(ana);

        transaction.commit();
        session.close();
    }
    public static void mainReadAndUpdate( String[] args ) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserEntity john = session.find(UserEntity.class, 1);
        System.out.println(john);

        john.setAge(26);
        System.out.println(john);

        transaction.commit();
        session.close();
    }
}
