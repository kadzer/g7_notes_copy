import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Bedroom singleRoom;
    Bedroom doubleRoom;

    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;

    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before() {
        hotel = new Hotel("CodeClan Towers");
        singleRoom = new Bedroom(101, "Single", 1, 25.00);
        doubleRoom = new Bedroom(102, "Double", 2, 50.00);

        conferenceRoom = new ConferenceRoom("Charles Babbage Suite", 2, 1000.00);
        diningRoom = new DiningRoom("Canteen", 2);

        guest1 = new Guest("Ada Lovelace");
        guest2 = new Guest("Alan Turing");
        guest3 = new Guest("Clive Sinclair");
    }

    @Test
    public void hasName() {
        assertEquals("CodeClan Towers", hotel.getName());
    }

    @Test
    public void bedRoomCountStartsAtZero() {
        assertEquals(0, hotel.bedroomCount());
    }

    @Test
    public void canAddBedroom() {
        hotel.addBedroom(singleRoom);
        assertEquals(1, hotel.bedroomCount());
    }

    @Test
    public void canAddConferenceRoom() {
        hotel.addConferenceRoom(conferenceRoom);
        assertEquals(1, hotel.conferenceRoomCount());
    }

    @Test
    public void canSetDiningRoom() {
        hotel.addDiningRoom(diningRoom);
        assertEquals(1, hotel.diningRoomCount());
    }

    @Test
    public void canCheckGuestsIntoConferenceRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        hotel.addConferenceRoom(conferenceRoom);
        hotel.checkInGuestsToConferenceRoom(guestList, conferenceRoom.getName());
        assertEquals(2, conferenceRoom.numberOfGuests());
    }

    @Test
    public void cannotCheckTooManyGuestsIntoConferenceRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        guestList.add(guest3);
        hotel.addConferenceRoom(conferenceRoom);
        hotel.checkInGuestsToConferenceRoom(guestList, conferenceRoom.getName());
        assertEquals(2, conferenceRoom.numberOfGuests());
    }

    @Test
    public void canCheckGuestsIntoDiningRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        hotel.addDiningRoom(diningRoom);
        hotel.checkInGuestsToDiningRoom(guestList, diningRoom.getName());
        assertEquals(2, diningRoom.numberOfGuests());
    }

    @Test
    public void cannotCheckTooManyGuestsIntoDiningRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        guestList.add(guest3);
        hotel.addDiningRoom(diningRoom);
        hotel.checkInGuestsToDiningRoom(guestList, diningRoom.getName());
        assertEquals(2, diningRoom.numberOfGuests());
    }

    @Test
    public void canGetGuestsCheckedIntoBedroom() {
        hotel.addBedroom(singleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkInGuestsToBedroom(singleRoom.getNumber(), guestList);
        ArrayList<Guest> guests = hotel.getGuestsCheckedIntoBedroom(singleRoom.getNumber());
        assertEquals(1, guests.size());
        assertEquals("Ada Lovelace", guests.get(0).getName());
    }


    @Test
    public void canCheckGuestIntoBedroom() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkInGuestsToBedroom(singleRoom.getNumber(), guestList);
        ArrayList<Guest> guests = hotel.getGuestsCheckedIntoBedroom(singleRoom.getNumber());
        assertEquals(1, guests.size());
        assertEquals("Ada Lovelace", guests.get(0).getName());
    }

    @Test
    public void canCheckGuestOutOfBedroom() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkInGuestsToBedroom(singleRoom.getNumber(), guestList);

        hotel.checkGuestsOutOfBedroom(singleRoom.getNumber());
        ArrayList<Guest> guests = hotel.getGuestsCheckedIntoBedroom(singleRoom.getNumber());
        assertEquals(0, guests.size());
    }
    @Test
    public void canGetVacantBedroomsAllStartFree() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);

        ArrayList<Bedroom> vacantBedrooms = hotel.getAvailableBedrooms();
        assertEquals(2, vacantBedrooms.size());
    }

    @Test
    public void canGetVacantBedroomsOneOccupied() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);

        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkInGuestsToBedroom(singleRoom.getNumber(), guestList);

        ArrayList<Bedroom> vacantBedrooms = hotel.getAvailableBedrooms();
        assertEquals(1, vacantBedrooms.size());
    }

    @Test
    public void canCheckGuestIntoBedroomForNumberOfNights() {
        hotel.addBedroom(singleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkGuestsIntoBedroomForNumberOfNights(singleRoom.getNumber(), guestList, 2);
        assertEquals(2, singleRoom.getNumberOfNights());
    }
}
