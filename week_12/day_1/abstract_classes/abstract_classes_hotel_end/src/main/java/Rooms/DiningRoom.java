package Rooms;

public class DiningRoom extends Room {

    private String name;

    public DiningRoom(String name, int capacity) {
        super(capacity);
       this.name = name;
    }

    public String getName() {
        return name;
    }


    public void checkOut() {
        getGuests().remove(0);
    }
}
