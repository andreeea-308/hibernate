package sda.hibernate.many2many.actions;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.utils.HibernateUtils;

public class ReadMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     * <p>
     * Fetch all classrooms from database using a Query object:
     * - on session instance, call 'createQuery' and give as argument an HQL query that selects all classrooms from database
     * - fetch query result using 'getResultList' on query instance
     * - iterate over list and print elements to console
     * <p>
     * Watch over console to see results and how Hibernate execute SQL queries.
     * Great job!
     */

    public static void mainSimpleRead(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Classroom> query = session.createQuery("select c from Classroom c where c.id = :id", Classroom.class);
        query.setParameter("id", 4);
        System.out.println(query.getSingleResult());

        transaction.commit();
        session.close();

    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Trainer ana = session.find(Trainer.class, 4);
        Trainer val = session.find(Trainer.class, 5);
        Classroom classroom = new Classroom();
        classroom.setName("JavaRo68");
        classroom.addTrainer(ana);
        classroom.addTrainer(val);
        session.persist(classroom);
        System.out.println(classroom);

        transaction.commit();
        session.close();

    }

}
