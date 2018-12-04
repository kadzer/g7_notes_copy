import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicCarpetTest {

    MagicCarpet magicCarpet;

    @Before
    public void before(){
        magicCarpet = new MagicCarpet("Yellow");
    }

    @Test
    public void hasColour(){
        assertEquals("Yellow", magicCarpet.getColour());
    }

    @Test
    public void canFly(){
        assertEquals(magicCarpet.fly(),"Hovering up, straightening out, flying off!");
    }

}