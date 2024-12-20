package service;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import model.room.Room;
import model.room.RoomType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {
    private static Collection<Reservation> reservations =  new ArrayList<>();
    private static Collection<IRoom> rooms = new ArrayList<>();
    private static boolean isPopulatedWithTestData = false;

    public static void addRoom(String roomNumber, Double price, RoomType roomType) {
        rooms.add(new Room(roomNumber, price, roomType));
    }

    public static IRoom getRoom(String roomNumber) {
        for (IRoom room: rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public static Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
            reservations.add(reservation);
            return reservation;
        } catch (Exception e){
            System.out.println("Failure to create reservation");
        }
        return null;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new ArrayList<>();
        for (IRoom room : rooms) {
            boolean isAvailable = true;
            for (Reservation reservation : reservations) {
                if (reservation.getRoom().equals(room) &&
                        (!(checkOutDate.before(reservation.getCheckInDate()) || checkInDate.after(reservation.getCheckOutDate())))) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public static Collection<IRoom> findAllRooms() {
        return rooms;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        return reservations.stream().filter(reservation -> reservation.getCustomer() == customer).toList();
    }

    public static  Collection<Reservation> getAllReservations() {
        return reservations;
    }

    public static void populateRooms() {
        rooms.add(new Room("101", 100.0, RoomType.SINGLE));
        rooms.add(new Room("102", 200.0, RoomType.DOUBLE));
        rooms.add(new Room("103", 300.0, RoomType.DOUBLE));
    }

    public static void populateReservations() {
        reservations.add(new Reservation(CustomerService.getCustomer("gmail@gmail.com"), getRoom("101"), new Date(125, 1, 1), new Date(125, 1, 2)));
        reservations.add(new Reservation(CustomerService.getCustomer("gmail@gmail.com"), getRoom("102"), new Date(125, 1, 1), new Date(125, 1, 2)));
    }

    public static void populateCustomers() {
        CustomerService.addCustomer("gmail@gmail.com", "John", "Doe");
    }

    public static void populateData() {
        if (isPopulatedWithTestData) {
            System.out.println("Data already populated");
            return;
        }
        populateRooms();
        populateCustomers();
        populateReservations();
        isPopulatedWithTestData = true;
        System.out.println("Data populated successfully");
    }
}
