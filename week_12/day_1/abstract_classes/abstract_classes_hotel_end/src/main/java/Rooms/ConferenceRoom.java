package Rooms;

public class ConferenceRoom extends Room{
    private double pricePerDay;
    private String name;

    public ConferenceRoom(String name, int capacity, double pricePerDay) {
        super(capacity);
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    public String getName() {
        return name;
    }


    public double getPricePerDay() {
        return this.pricePerDay;
    }


    public void checkOut() {
        getGuests().remove(0);
    }


}
