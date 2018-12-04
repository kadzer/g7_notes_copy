import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airport {
    private AirportCode airportCode;
    private ArrayList<Hangar> hangars;
    private ArrayList<Flight> flights;

    public Airport(ArrayList<Hangar> hangars, AirportCode airportCode, ArrayList<Flight> flights) {
        this.hangars = hangars;
        this.airportCode = airportCode;
        this.flights = flights;
    }

    public int numberOfHangars() {
        return this.hangars.size();
    }

    public AirportCode getAirportCode() {
        return airportCode;
    }

    public int numberOfFlights() {
        return flights.size();
    }

    public void addHangar(Hangar hangar) {
        this.hangars.add(hangar);
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void addPlaneToHangar(Plane plane) {
        for (Hangar hangar : this.hangars) {
            if (hangar.numberOfPlanes() < hangar.getCapacity()) {
                hangar.addPlane(plane);
                break;
            }
        }
    }

    public int numberOfPlanesInHangars() {
        int total = 0;
        for (Hangar hangar : this.hangars) {
            total += hangar.numberOfPlanes();
        }
        return total;
    }

    public void createFlight(AirportCode destination, AirlineType airline) {
        Plane planeForFlight = null;
        for (Hangar hangar : this.hangars) {
            for (Plane plane : hangar.getPlanes()) {
                if (!plane.assignedToFlight && plane.getAirline().equals(airline)) {
                    planeForFlight = plane;
                    plane.setAssignedToFlight(true);
                    break;
                }
            }
        }

        Random rnd = new Random();
        String flightNumber = airline.toString().substring(0, 1) + rnd.nextInt(9999);

        Flight flight = new Flight(planeForFlight, flightNumber, destination);
        addFlight(flight);
    }

    public void sellTicket(Passenger passenger, AirportCode destination) {
        for (Flight flight : this.flights) {
            if (flight.getDestinationCode().equals(destination)) {
                if (flight.needsNewPlane()) {
                    assignNewPlane(flight);
                }
                flight.addPassenger(passenger);
                passenger.setPassengerNumber(flight.numberOfPassengers());
                break;
            }
        }
    }

    private void assignNewPlane(Flight flight) {
        for (Hangar hangar : this.hangars) {
            for (Plane plane : hangar.getPlanes()) {
                if (plane.getCapacity() > flight.numberOfPassengers()) {
                    plane.addCollectionOfPassengers(flight.unboard());
                    flight.setPlane(plane);
                }
            }
        }
    }

    public Flight getFlightByNumber(String flightNumber) {
        for (Flight flight : this.flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public int numberOfPassengers(Flight flightToFind) {
        for (Flight flight : this.flights) {
            if (flight == flightToFind) {
                return flight.numberOfPassengers();
            }
        }
        return 0;
    }

    public ArrayList<Plane> planesForFlight(Flight flight) {
        ArrayList<Plane> result = new ArrayList<>();

        for (Hangar hangar : this.hangars) {
            for (Plane plane : hangar.getPlanes()) {
                if (plane.getCapacity() > flight.numberOfPassengers()) {
                    result.add(plane);
                }
            }
        }

        return result;
    }

    public Passenger findPassengerByNumberLinearSearch(int passengerNumber, Flight flight) {
        for (Passenger passenger : flight.getPassengers()) {
            if (passenger.getPassengerNumber() == passengerNumber) {
                return passenger;
            }
        }
        return null;
    }
}
