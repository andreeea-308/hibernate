package sda.hibernate.one2many.bidirectionalActions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class Insert {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Create a new Post and add 2 comments using utility method 'addComment' and insert in database using session instance (methods 'persist' or 'merge')
     * Commit transaction and close session.
     * What is printed in console?
     *
     * If you see only 3 inserted statement, then you configure Hibernate very efficiently. Great work!
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Post post = new Post("Who is going to the mountains");
        PostComment postComment = new PostComment("Lele goes to the mountains");
        PostComment postComment1 = new PostComment("Marian goes to the mountains");
        post.addComment(postComment);
        post.addComment(postComment1);
        session.persist(post);
        System.out.println(post);


        transaction.commit();
        session.close();
    }
}
