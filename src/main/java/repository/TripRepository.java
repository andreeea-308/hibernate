package repository;

import exercise1.Trip;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TripRepository {
    private Session session;

    public TripRepository(Session session) {
        this.session = session;
    }
    public Trip fiindById(int id){
        return session.find(Trip.class, id);
    }
    public Trip saveTrip(Trip trip){
        session.persist(trip);
        return trip;
    }

}
