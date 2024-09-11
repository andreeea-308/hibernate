package exercise1;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "destination")
    private String destination;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Passenger> passengers = new ArrayList<>();
    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TripAvailability availability;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public TripAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(TripAvailability availability) {
        this.availability = availability;
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
        passenger.setTrip(this);
    }
    public void removePassenger(Passenger passenger){
        this.passengers.remove(passenger);
        passenger.setTrip(null);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", passengers=" + passengers +
                ", availability=" + availability +
                '}';
    }
}
