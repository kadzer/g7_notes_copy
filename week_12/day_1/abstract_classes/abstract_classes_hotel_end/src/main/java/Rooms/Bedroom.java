package Rooms;

public class Bedroom extends Room {
    private int number;
    private BedRoomType type;
    private double pricePerNight;


    public Bedroom(int number, BedRoomType type, int capacity, double pricePerNight) {
        super(capacity);
        this.type = type;
        this.number = number;
        this.pricePerNight = pricePerNight;
    }

    public int getNumber() {
        return this.number;
    }

    public BedRoomType getType() {
        return this.type;
    }



    public double getPricePerNight() {
        return this.pricePerNight;
    }

    public void checkOut(){
        getGuests().clear();
    }


}
