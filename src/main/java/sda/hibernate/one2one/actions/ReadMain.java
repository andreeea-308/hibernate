package sda.hibernate.one2one.actions;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.one2one.Country;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class ReadMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     *
     * Fetch all countries from database using a Query object:
     * - on session instance, call 'createQuery' and give as argument an HQL query that selects all countries from database
     * - fetch query result using 'getResultList' on query instance
     * - iterate over list and print elements to console
     *
     * Watch over console to see results and how Hibernate execute SQL queries.
     * Great job!
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Country> query = session.createQuery("select c from Country c left join fetch c.capital", Country.class);
        List<Country> countries = query.getResultList();
        countries.stream().forEach(System.out::println);

        transaction.commit();
        session.close();
    }

}
