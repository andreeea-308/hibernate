package sda.hibernate.many2many.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.one2many.Post;
import sda.hibernate.utils.HibernateUtils;

public class InsertMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Create a new Classroom (set a name and add 2 trainers to it) and insert in database using session instance (methods 'persist' or 'merge')
     * After calling 'persist' method, print post to console. Commit transaction and close session.
     * What is printed in console? Also check the database.
     *
     * Next, create a new Classroom and assign an existing trainer from db
     *
     * Great job! You insert some rows in database. Now lets read them!
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Classroom classroom = new Classroom();
        classroom.setName("JavaRo67");
        Trainer ana = new Trainer("Ana");
        Trainer val = new Trainer("Val");
        classroom.addTrainer(ana);
        classroom.addTrainer(val);
        session.persist(classroom);
        System.out.println(classroom);

        transaction.commit();
        session.close();

    }

}
