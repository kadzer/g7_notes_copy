import java.util.ArrayList;

public class Bedroom {
    private int number;
    private String type;
    private int capacity;
    private double pricePerNight;
    private int numberOfNights;
    private ArrayList<Guest> guests;


    public Bedroom(int number, String type, int capacity, double pricePerNight) {
        this.type = type;
        this.number = number;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
        this.pricePerNight = pricePerNight;
        this.numberOfNights = 0;
    }

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int numberOfGuests(){
        return this.guests.size();
    }

    public double getPricePerNight() {
        return this.pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isFull() {
        return this.numberOfGuests() == this.capacity;
    }

    public void checkIn(Guest guest) {
        if (!isFull()) {
            this.guests.add(guest);
        }
    }

    public ArrayList<Guest> getGuests() {
        return new ArrayList<>(guests);
    }

    public void checkOut(){
        this.guests = new ArrayList<>();
    }

    public void checkInGuestsForNumberOfNights(ArrayList<Guest> guests, int numberOfNights) {
        if (numberOfNights > 0) {
            checkInGuests(guests);
            this.numberOfNights = numberOfNights;
        }

    }

    public void checkInGuests(ArrayList<Guest> guestsToCheckIn) {
        if (!isFull()) {

            for (Guest guest : guestsToCheckIn) {
                checkIn(guest);
            }
        }
    }
}
