package repository;

import exercise1.TripAvailability;
import org.hibernate.Session;

public class TripAvailabilityRepository {
    private Session session;

    public TripAvailabilityRepository(Session session) {
        this.session = session;
    }

    public void decrementNumberOfSeats(int tripAvailabilityid, int requestedNumberOfSeats){
        TripAvailability tripAvailability = session.find(TripAvailability.class, tripAvailabilityid);
        tripAvailability.decrementSeats(requestedNumberOfSeats);
    }
}
