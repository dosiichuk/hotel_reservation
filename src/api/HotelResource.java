package api;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastname) {
        CustomerService.addCustomer(email, firstName, lastname);
    }

    public IRoom getRoom(String roomNumber) {
        return ReservationService.getRoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return ReservationService.reserveRoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return ReservationService.getCustomerReservation(getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return ReservationService.findRooms(checkInDate, checkOutDate);
    }
}
