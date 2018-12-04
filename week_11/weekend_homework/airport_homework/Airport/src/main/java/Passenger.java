public class Passenger {
    private String name;
    private int baggageWeight;
    private int passengerNumber;

    public Passenger(String name, int baggageWeight) {
        this.name = name;
        this.baggageWeight = baggageWeight;
        this.passengerNumber = 0;
    }

    public String getName() {
        return name;
    }

    public int getBaggageWeight() {
        return this.baggageWeight;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }
}
