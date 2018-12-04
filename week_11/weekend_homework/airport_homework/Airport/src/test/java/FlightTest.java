import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight;
    private Plane plane;

    @Before
    public void setUp() throws Exception {
        plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
        flight = new Flight(plane, "FR578", AirportCode.FRA);
    }

    @Test
    public void shouldHavePlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void shouldHaveAFlightNumber() {
        assertEquals("FR578", flight.getFlightNumber());
    }

    @Test
    public void shouldHaveDestinationAirport() {
        assertEquals(AirportCode.FRA, flight.getDestinationCode());
    }

    @Test
    public void shouldBeAbleToAddPassengerToPlane() {
        Passenger passenger = new Passenger("Pat", 50);
        flight.addPassenger(passenger);
        assertEquals(1, flight.numberOfPassengers());
    }
}
