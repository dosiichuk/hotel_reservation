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
    private static final ReservationService instance = new ReservationService();
    private final CustomerService customerService = CustomerService.getInstance();
    private Collection<Reservation> reservations =  new ArrayList<>();
    private Collection<IRoom> rooms = new ArrayList<>();
    private boolean isPopulatedWithTestData = false;

    private ReservationService() {
    }

    public void addRoom(String roomNumber, Double price, Integer roomType) {
        rooms.add(new Room(roomNumber, price, roomType));
    }

    public IRoom getRoom(String roomNumber) {
        for (IRoom room: rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
            reservations.add(reservation);
            return reservation;
        } catch (Exception e){
            System.out.println("Failure to create reservation");
        }
        return null;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
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

    public Collection<IRoom> findAllRooms() {
        return rooms;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        return reservations.stream().filter(reservation -> reservation.getCustomer() == customer).toList();
    }

    public Collection<Reservation> getAllReservations() {
        return reservations;
    }

    public void populateRooms() {
        rooms.add(new Room("101", 100.0, 1));
        rooms.add(new Room("102", 200.0, 2));
        rooms.add(new Room("103", 300.0, 2));
    }

    public void populateReservations() {
        reservations.add(new Reservation(customerService.getCustomer("gmail@gmail.com"), getRoom("101"), new Date(125, 1, 1), new Date(125, 1, 2)));
        reservations.add(new Reservation(customerService.getCustomer("gmail@gmail.com"), getRoom("102"), new Date(125, 1, 1), new Date(125, 1, 2)));
    }

    public void populateCustomers() {
        customerService.addCustomer("gmail@gmail.com", "John", "Doe");
    }

    public void populateData() {
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

    public static ReservationService getInstance() {
        return instance;
    }
}
