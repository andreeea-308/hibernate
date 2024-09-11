package main;

import exercise1.Passenger;
import exercise1.Trip;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.TripAvailabilityRepository;
import repository.TripRepository;
import utils.HibernateUtils;

public class MainRepository {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            TripRepository tripRepository = new TripRepository(session);
            Trip trip1 = tripRepository.fiindById(1);
            Passenger passenger = new Passenger();
            passenger.setName("Alex");
            trip1.addPassenger(passenger);

            TripAvailabilityRepository tripAvailabilityRepository = new TripAvailabilityRepository(session);
            tripAvailabilityRepository.decrementNumberOfSeats(trip1.getAvailability().getId(), 1);
            transaction.commit();
        }catch (RuntimeException e){
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

    }
}
