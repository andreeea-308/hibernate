package sda.hibernate.one2many.bidirectionalActions;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

public class Delete {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     * Fetch a Post from database and delete the first PostComment from 'comments' using remove utility method
     * Commit transaction and close session. Watch in database what was removed
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Post post1 = session.find(Post.class, 5);
        session.remove(post1);

        transaction.commit();
        session.close();
    }
}
