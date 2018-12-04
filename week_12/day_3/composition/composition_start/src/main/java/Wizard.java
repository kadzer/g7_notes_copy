import behaviours.Flyable;
import behaviours.Protector;
import mythical.Dragon;

public class Wizard {
    String name;
    Flyable ride;
    Protector protector;

    public Wizard(String name, Flyable ride, Protector protector){
        this.name = name;
        this.ride = ride;
        this.protector = protector;
    }

    public String getName(){
        return this.name;
    }

    public Flyable getRide() {
        return ride;
    }

    public String fly(){
        return this.ride.fly();
    }

    public void setRide(Flyable ride) {
        this.ride = ride;
    }

    public String protect(){
       return this.protector.attack();
    }

    public void setProtector(Protector protector){
        this.protector = protector;
    }


}