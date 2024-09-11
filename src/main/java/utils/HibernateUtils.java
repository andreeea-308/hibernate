package utils;

import exercise1.Passenger;
import exercise1.Trip;
import exercise1.TripAvailability;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
                    .setProperty(Environment.URL, "jdbc:mysql://localhost:3306/exercitii-hibernate")
                    .setProperty(Environment.USER, "root")  // de modificat si aici
                    .setProperty(Environment.PASS, "3182")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty(Environment.HBM2DDL_AUTO, "none")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .setProperty(Environment.FORMAT_SQL, "true")
                    .setProperty(Environment.HIGHLIGHT_SQL, "true")
                    .addAnnotatedClass(Trip.class)
                    .addAnnotatedClass(TripAvailability.class)
                    .addAnnotatedClass(Passenger.class)
                    ;

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}