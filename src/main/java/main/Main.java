package main;

import exercise1.Trip;
import exercise1.TripAvailability;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        if (!entityTransaction.isActive()){
            entityTransaction.begin();
        }

        TripAvailability tripAvailability = entityManager.find(TripAvailability.class, 3);
        tripAvailability.setAvailableSeats(0);

        entityTransaction.commit();
        entityManager.close();
    }
}
