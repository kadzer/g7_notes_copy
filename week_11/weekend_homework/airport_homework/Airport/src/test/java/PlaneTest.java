import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    private Plane plane;

    @Before
    public void setUp() throws Exception {
        plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
    }

    @Test
    public void shouldHaveAirline() {
        assertEquals(AirlineType.RYANAIR, plane.getAirline());
    }

    @Test
    public void shouldHavePlaneType() {
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void shouldHaveCapacity() {
        assertEquals(500, plane.getCapacity());
    }

    @Test
    public void shouldStartWithEmptyListOfPassengers() {
        assertEquals(0, this.plane.getNumberOfPassengers());
    }

    @Test
    public void shouldBeAbleToAddPassenger() {
        Passenger passenger = new Passenger("Pat", 50);
        plane.addPassenger(passenger);
        assertEquals(1, plane.getNumberOfPassengers());
    }

    @Test
    public void shouldBeAbleToSortPassengersByNumber() {
//      adds 50 passengers with random passenger numbers
        for (int i = 0; i < 50; i++){
            Passenger passenger = new Passenger("Pat", 50);
            Random rnd = new Random();
            passenger.setPassengerNumber(rnd.nextInt(500));
            plane.addPassenger(passenger);
        }

        plane.sortPassengersByNumberBubbleSort();

        boolean isSorted = true;
        for (int i = 0; i < plane.getPassengers().size() - 2; i++){
            if (plane.getPassengers().get(i).getPassengerNumber() > plane.getPassengers().get(i + 1).getPassengerNumber()){
                isSorted = false;
            }
        }

        assertEquals(true, isSorted);
    }
}
