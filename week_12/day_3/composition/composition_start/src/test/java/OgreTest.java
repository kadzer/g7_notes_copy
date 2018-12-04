import mythical.Ogre;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class OgreTest {

    Ogre ogre;

    @Before
    public void before(){
        ogre = new Ogre("Freddie");
    }

    @Test
    public void hasName(){
        assertEquals("Freddie", ogre.getName());
    }
}