package sda.hibernate.one2many.actions;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class Update {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a transaction
     *
     * Steps to update a row in database using Hibernate:
     * - use session object to fetch a Post from database by id
     * - set another content to that Post
     * - commit transaction and close session
     *
     * Great job! Check in database how data is changed.
     */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Post post = session.find(Post.class, 4);
//        post.setContent("Mountains trip");
        PostComment postComment = new PostComment("Andreea goes to the mountains");
        post.getPostComments().add(postComment);

        transaction.commit();
        session.close();

        System.out.println(post);
    }

}
