package sda.hibernate.many2many.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.utils.HibernateUtils;

public class DeletMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Classroom javaRo67 = session.find(Classroom.class, 4);
        session.remove(javaRo67);

        transaction.commit();
        session.close();
    }
}
