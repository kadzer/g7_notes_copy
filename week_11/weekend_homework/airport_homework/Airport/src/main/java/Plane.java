import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plane {
    private PlaneType planeType;
    private AirlineType airline;
    private List<Passenger> passengers;
    public boolean assignedToFlight;

    public Plane(PlaneType planeType, AirlineType airline, List<Passenger> passengers) {
        this.planeType = planeType;
        this.airline = airline;
        this.passengers = passengers;
        this.assignedToFlight = false;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public AirlineType getAirline() {
        return airline;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(this.passengers);
    }

    public int getNumberOfPassengers(){
        return this.passengers.size();
    }

    public int getCapacity() {
        return this.planeType.getCapacity();
    }

    public boolean isAssignedToFlight() {
        return assignedToFlight;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void empty(){
        this.passengers.clear();
    }

    public void addCollectionOfPassengers(List<Passenger> passengers){
        for (Passenger passenger : passengers){
            addPassenger(passenger);
        }
    }

    public void setAssignedToFlight(boolean assignedToFlight) {
        this.assignedToFlight = assignedToFlight;
    }

    public void sortPassengersByNumberBubbleSort() {
        for (int i = 0; i < this.passengers.size(); i++) {
            boolean swapped = false;
            for (int j = 1; j < this.passengers.size() - 1; j++) {
                if (this.passengers.get(j - 1).getPassengerNumber() > this.passengers.get(j).getPassengerNumber()) {
                    Passenger temp = getPassengers().get(j - 1);
                    this.passengers.set(j - 1, this.passengers.get(j));
                    this.passengers.set(j, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
