package sda.hibernate.one2many.bidirectionalActions;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.one2many.Post;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class Read {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Fetch a Post from db and print it to console.
     *
     * Next, create a Query from session using 'createQuery' method.
     * The query will be: "select p from Post p join fetch PostComment pc on pc.postVariable.id = p.id where pc.id = :id"
     * Set parameter on query object and then fetch result using 'getSingleResult' or 'getResultList'
     * Print result on console.
     *
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Post> query = session.createQuery("select p from Post p left join p.postComments pc on pc.postVariable.id = p.id with pc.id = :id",
                Post.class);
        query.setParameter("id", 7);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        transaction.commit();
        session.close();
    }
}
