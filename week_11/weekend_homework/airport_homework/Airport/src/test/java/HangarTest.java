import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HangarTest {
    private Hangar hangar;

    @Before
    public void setUp() throws Exception {
        hangar = new Hangar(new ArrayList<>(),5);
    }

    @Test
    public void shouldStartWithEmptyCollectionOfPlanes() {
        assertEquals(0, hangar.numberOfPlanes());
    }

    @Test
    public void shouldBeAbleToAddPlanesToHangars() {
        Plane plane = new Plane(PlaneType.BOEING747, AirlineType.RYANAIR, new ArrayList<>());
        hangar.addPlane(plane);
        assertEquals(1, hangar.numberOfPlanes());
    }
}
