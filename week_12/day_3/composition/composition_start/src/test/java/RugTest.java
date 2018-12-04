import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RugTest {

    Rug rug;

    @Before
    public void before(){
        rug = new Rug("Yellow");
    }

    @Test
    public void hasColour(){
        assertEquals("Yellow",rug.getColour());
    }

}