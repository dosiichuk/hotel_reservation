package api;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import model.room.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;

public class AdminResource {
    private static final AdminResource instance = new AdminResource();
    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    private AdminResource() {
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(String roomNumber, double price, Integer roomType) {
        reservationService.addRoom(roomNumber, price, roomType);
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.findAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Collection<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    public void populateData() {
        reservationService.populateData();
    }

    public static AdminResource getInstance() {
        return instance;
    }
}
