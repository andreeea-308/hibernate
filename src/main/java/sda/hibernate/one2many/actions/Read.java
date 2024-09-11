package sda.hibernate.one2many.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class Read {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     *
     * Fetch all posts from database using a Query object:
     * - on session instance, call 'createQuery' and give as argument an HQL query that selects all Post from database
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

        Query<Post> query = session.createQuery("select p from Post p left join fetch p.postComments", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        transaction.commit();
        session.close();
    }

}
