package exercise1;

import jakarta.persistence.*;

@Entity
@Table(name = "trip_availability")
public class TripAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "available_seats")
    private int availableSeats;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void decrementSeats(int requestedNumberOfSeats) {
        if (requestedNumberOfSeats > this.availableSeats) {
            throw new RuntimeException("Not enough seats for this trip!");
        } else {
            availableSeats = availableSeats - requestedNumberOfSeats;
        }
    }

    @Override
    public String toString() {
        return "TripAvailability{" +
                "id=" + id +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
