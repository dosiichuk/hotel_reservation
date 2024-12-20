package api;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import model.room.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;

public class AdminResource {
    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void addRoom(String roomNumber, double price, RoomType roomType) {
        ReservationService.addRoom(roomNumber, price, roomType);
    }

    public static Collection<IRoom> getAllRooms() {
        return ReservationService.findAllRooms();
    }

    public static Collection<Customer> getAllCustomers() {
        return CustomerService.getAllCustomers();
    }

    public static Collection<Reservation> getAllReservations() {
        return ReservationService.getAllReservations();
    }
}
