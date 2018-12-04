import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<DiningRoom> diningRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(String name) {
        this.name = name;
        bedrooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        diningRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public int bedroomCount() {
        return this.bedrooms.size();
    }

    public int conferenceRoomCount() {
        return this.conferenceRooms.size();
    }


    public int diningRoomCount() {
        return this.diningRooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addDiningRoom(DiningRoom room) {
        this.diningRooms.add(room);
    }

    public void addConferenceRoom(ConferenceRoom room) {
        this.conferenceRooms.add(room);
    }

    public void checkInGuestsToBedroom(int roomNumber, ArrayList<Guest> guestList) {
        for (Bedroom bedroom : this.bedrooms) {
            if (roomNumber == bedroom.getNumber()) {
                for (Guest guest : guestList) {
                    bedroom.checkIn(guest);
                }
            }
        }
    }


    public void checkInGuestsToDiningRoom(ArrayList<Guest> guests, String name) {
        for (DiningRoom room : this.diningRooms) {
            if (room.getName() == name) {
                for (Guest guest : guests) {
                    room.checkIn(guest);
                }
            }
        }
    }


    public void checkInGuestsToConferenceRoom(ArrayList<Guest> guests, String name) {
        for (ConferenceRoom room : this.conferenceRooms) {
            if (room.getName() == name) {
                for (Guest guest : guests) {
                    room.checkIn(guest);
                }
            }
        }

    }

    public ArrayList<Guest> getGuestsCheckedIntoBedroom(int number) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                return room.getGuests();
            }
        }
        return new ArrayList<Guest>();
    }




    public void checkGuestsOutOfBedroom(int roomNumber) {
        for (Bedroom room : this.bedrooms) {
            if (room.getNumber() == roomNumber) {
                room.checkOut();
            }
        }
    }


    public void checkGuestsIntoBedroomForNumberOfNights(int number, ArrayList<Guest> guestList, int numberOfNights) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                room.checkInGuestsForNumberOfNights(guestList, numberOfNights);
                return;
            }
        }
    }

    public ArrayList<Bedroom> getAvailableBedrooms() {
        ArrayList<Bedroom> availableRooms = new ArrayList<Bedroom>();
        for (Bedroom room : bedrooms) {
            if (room.numberOfGuests() == 0) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
