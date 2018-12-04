import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {
    private Plane plane;
    private String flightNumber;
    private AirportCode destination;

    public Flight(Plane plane, String flightNumber, AirportCode destination) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public AirportCode getDestinationCode() {
        return destination;
    }

    public void addPassenger(Passenger passenger) {
        this.plane.addPassenger(passenger);
    }

    public List<Passenger> getPassengers(){
        return this.plane.getPassengers();
    }

    public int numberOfPassengers() {
        return this.plane.getNumberOfPassengers();
    }

    public int capacity() {
        return this.plane.getCapacity();
    }

    public boolean needsNewPlane() {
        return plane.getNumberOfPassengers() >= plane.getCapacity();
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public List<Passenger> unboard(){
        List<Passenger> passengers = plane.getPassengers();
        plane.empty();
        return passengers;
    }

    public void sortPassengersByNumber(){
        this.plane.sortPassengersByNumberBubbleSort();
    }
}
