import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    private Passenger passenger;

    @Before
    public void setUp() throws Exception {
        passenger = new Passenger("Pat", 50);
    }

    @Test
    public void shouldHaveName() {
        assertEquals("Pat", passenger.getName());
    }

    @Test
    public void shouldHaveBaggageWeight() {
        assertEquals(50, passenger.getBaggageWeight());
    }
}
