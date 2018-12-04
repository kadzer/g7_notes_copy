import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MopTest {

    Mop mop;

    @Before
    public void before(){
        mop = new Mop("Hygenic");
    }

    @Test
    public void hasBrand(){
        assertEquals("Hygenic", mop.getBrand());
    }

}