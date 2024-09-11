package sda.hibernate.one2one.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2one.Capital;
import sda.hibernate.one2one.Country;
import sda.hibernate.utils.HibernateUtils;

public class InsertMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     *
     * Scenario 1:
     * Create a new Country (set a name and a Capital) and insert in database using session instance (methods 'persist' or 'merge')
     * After calling 'persist' method, print country to console. Commit transaction and close session.
     * What is printed in console? Also check the database.
     *
     * Scenario 2:
     * Insert in database a Country, using a capital that already exists in database
     * First, fetch the capital from database
     * Create a new Country, set a name and the capital fetched. Save it to database
     *
     * Great job! You insert some rows in database.
     */

    public static void mainScenario1(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Capital paris = new Capital("Paris");
        Capital madrid = new Capital("Madrid");
        Country france = new Country("France", paris);
        session.persist(france);
        session.persist(madrid);
        System.out.println(france);

        transaction.commit();
        session.close();
    }
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Country italy = new Country("Italy", session.find(Capital.class, 5));
        session.persist(italy);

        transaction.commit();
        session.close();
    }

}
