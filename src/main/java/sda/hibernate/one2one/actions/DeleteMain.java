package sda.hibernate.one2one.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.hibernate.one2one.Country;
import sda.hibernate.utils.HibernateUtils;

public class DeleteMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     *
     * Fetch a country from database and delete it using 'remove' method on session instance
     * Commit transaction and close session
     *
     * Watch in database what was removed
     *
     * Great job!
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Country romania = session.find(Country.class, 1);
        session.remove(romania);

        transaction.commit();
        session.close();
    }

}
