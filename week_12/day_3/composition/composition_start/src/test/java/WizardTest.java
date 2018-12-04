import mythical.Dragon;
import mythical.Ogre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard wizard;
    Broomstick broomstick;
    Dragon dragon;

    @Before
    public void before(){
        dragon = new Dragon("Smaug");
        broomstick = new Broomstick("Nimbus", 10);
        wizard = new Wizard("Toby", broomstick, dragon);
    }

    @Test
    public void hasName(){
        assertEquals("Toby", wizard.getName());
    }

    @Test
    public void hasBroomstick(){
        Broomstick ride = (Broomstick)wizard.getRide();
        assertEquals("Nimbus", ride.getBrand());
    }

    @Test
    public void canFly(){
        assertEquals("mounting broom, running, skipping, flying!", wizard.fly());
    }

    @Test
    public void canFlyDragon(){
        Dragon dragon = new Dragon("Smaug");
        wizard.setRide(dragon);
        assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
    }

    @Test
    public void canProtect(){
        assertEquals("Breathing fire on your enemies", wizard.protect());
    }
}