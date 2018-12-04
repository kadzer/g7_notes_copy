package Rooms;

import Guests.Guest;

import java.util.ArrayList;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    protected ArrayList<Guest> getGuests() {
        return guests;
    }

    public int numberOfGuests(){
        return this.guests.size();
    }

    public boolean isFull() {
        return this.numberOfGuests() == this.capacity;
    }

    public void checkIn(Guest guest) {
        if (!isFull()) {
            this.guests.add(guest);
        }
    }

    public abstract void checkOut();
}
