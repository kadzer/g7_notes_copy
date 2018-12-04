import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    private Airport airport;

    @Before
    public void setUp() {
        airport = new Airport(new ArrayList<>(), AirportCode.GLA, new ArrayList<>());
    }

    @Test
    public void shouldStartWithEmptyCollectionOfHangars() {
        assertEquals(0, airport.numberOfHangars());
    }

    @Test
    public void shouldHaveAnAirportCode() {
        assertEquals(AirportCode.GLA, airport.getAirportCode());
    }

    @Test
    public void shouldStartWithEmptyCollectionOfFlights() {
        assertEquals(0, airport.numberOfFlights());
    }

    @Test
    public void shouldBeAbleToAddHangars() {
        Hangar hangar = new Hangar(new ArrayList<>(), 5);
        airport.addHangar(hangar);
        assertEquals(1, airport.numberOfHangars());
    }

    @Test
    public void shouldBeAbleToAddPlanesToHangars() {
        Hangar hangar = new Hangar(new ArrayList<>(), 5);
        airport.addHangar(hangar);
        Plane plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
        airport.addPlaneToHangar(plane);
        assertEquals(1, airport.numberOfPlanesInHangars());
    }

    @Test
    public void shouldBeAbleToAddFlights() {
        Plane plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
        Flight flight = new Flight(plane, "FR756", AirportCode.FRA);
        airport.addFlight(flight);
        assertEquals(1, airport.numberOfFlights());
    }

    @Test
    public void shouldBeAbleToCreateFlightsWithPlanesInHangar() {
        Hangar hangar = new Hangar(new ArrayList<>(), 5);
        airport.addHangar(hangar);
        Plane plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
        airport.addPlaneToHangar(plane);
        airport.createFlight(AirportCode.FRA, AirlineType.RYANAIR);
        assertEquals(1, airport.numberOfFlights());
    }

    @Test
    public void shouldBeAbleToGetFlightByFlightNumber() {
        Flight flight = new Flight(new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>()), "FR756", AirportCode.FRA);
        airport.addFlight(flight);
        assertEquals(flight, airport.getFlightByNumber("FR756"));
    }

    @Test
    public void shouldBeAbleToSellTicketForFlight() {
        Flight flight = new Flight(new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>()), "FR756", AirportCode.LDN);
        airport.addFlight(flight);

        Passenger passenger = new Passenger("Pat", 50);
        airport.sellTicket(passenger, AirportCode.LDN);

        assertEquals(1, flight.numberOfPassengers());
    }

    @Test
    public void shouldBeAbleToGetPassengersForFlight() {
        Flight flight = new Flight(new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>()), "FR756", AirportCode.LDN);
        flight.addPassenger(new Passenger("Pat", 50));
        flight.addPassenger(new Passenger("Pete", 50));
        flight.addPassenger(new Passenger("Bob", 50));

        airport.addFlight(flight);
        assertEquals(3, airport.numberOfPassengers(flight));
    }

    @Test
    public void shouldReAssignAMoreAppropriatePlaneIfPassengerCapacityExceeded() {
        airport.addHangar(new Hangar(new ArrayList<>(), 2));

        Plane plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
        Plane plane2 = new Plane(PlaneType.BOEING767, AirlineType.RYANAIR, new ArrayList<>());
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane2);

        Flight flight = new Flight(plane, "FR756", AirportCode.FRA);
        airport.addFlight(flight);

        Passenger passenger = new Passenger("Pat", 50);
        for (int i = 0; i < 600; i++){
            airport.sellTicket(passenger, AirportCode.FRA);
        }

        assertEquals(plane2, airport.getFlightByNumber("FR756").getPlane());
    }

    @Test
    public void shouldBeAbleToFindListOfSuitablePlanes() {
        airport.addHangar(new Hangar(new ArrayList<>(), 3));

        Plane plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
        Plane plane2 = new Plane(PlaneType.BOEING767, AirlineType.RYANAIR, new ArrayList<>());
        Plane plane3 = new Plane(PlaneType.BOEING777, AirlineType.RYANAIR, new ArrayList<>());
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane2);
        airport.addPlaneToHangar(plane3);

        Flight flight = new Flight(plane, "FR756", AirportCode.FRA);
        airport.addFlight(flight);

        assertEquals(3, airport.planesForFlight(flight).size());
    }
}

