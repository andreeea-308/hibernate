package sda.hibernate.one2many.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class Insert {

    /**
     * (first)
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Create a new Post (set a content and add 2 comments to it) and insert in database using session instance (methods 'persist' or 'merge')
     * After calling 'persist' method, print post to console. Commit transaction and close session.
     * What is printed in console? Also check the database.
     *
     * Great job! You insert some rows in database. Now lets read them!
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        PostComment postComment = new PostComment("Andrei goes to the mountains");
        PostComment postComment1 = new PostComment("Ana goes to the mountains");
        Post post = new Post("Who is going to the mountains", List.of(postComment, postComment1));
        session.persist(post);
        System.out.println(post);

        transaction.commit();
        session.close();
    }

}
