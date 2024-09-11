package sda.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import sda.hibernate.gettingStarted.UserEntity;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.one2one.Capital;
import sda.hibernate.one2one.Country;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
                    .setProperty(Environment.URL, "jdbc:mysql://localhost:3306/sda-hibernate-67")
                    .setProperty(Environment.USER, "root")  // de modificat si aici
                    .setProperty(Environment.PASS, "3182")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty(Environment.HBM2DDL_AUTO, "none")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .setProperty(Environment.FORMAT_SQL, "true")
                    .setProperty(Environment.HIGHLIGHT_SQL, "true")
                    .addAnnotatedClass(UserEntity.class)
                    .addAnnotatedClass(Post.class)
                    .addAnnotatedClass(PostComment.class)
                    .addAnnotatedClass(Classroom.class)
                    .addAnnotatedClass(Trainer.class)
                    .addAnnotatedClass(Capital.class)
                    .addAnnotatedClass(Country.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}

/**
 * This class is used for configuring Hibernate using Java code (no external xml file is needed)
 *
 * As you can see, some properties was used in JDBC (driver, db url, credentials for db - user & password)
 *
 * The dialect specifies the type of database so Hibernate generate appropriate type of SQL statements
 *
 * HBM2DDL_AUTO is a placeholder for String "hibernate.hbm2ddl.auto"
 * "hibernate.hbm2ddl.auto" will tell Hibernate if and how it should create database tables based on entities from application
 * In our case is set to "none" so Hibernate will not create or alter tables based on Entities.
 * Another options could be (update, create - drop, drop etc)
 * (in real projects, the "none" option is often used or "update")
 *
 * SHOW_SQL, FORMAT_SQL, HIGHLIGHT_SQL - are used to nicely show SQL queries that Hibernate executes
 * so we can see in console what happens when using Hibernate (less magic, more understanding)
 *
 * method 'addAnnotatedClass(UserEntity.class)' makes Hibernate aware that UserEntity class is an entity and will be mapped to a table
 *
 * The last 2 line are used for building a SessionFactory instance.
 * SessionFactory will offer Session instances, which we'll use for communicate with database
 *
 * Another way to configure Hibernate is using a file named 'hibernate.cfg.xml' that need to be in 'resources' folder
 * Can check Journey to see an example
 */
