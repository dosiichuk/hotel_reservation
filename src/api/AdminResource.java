package api;

import model.customer.Customer;
import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;

public class AdminResource {
    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void addRoom(Collection<IRoom> rooms) {
        ReservationService.addRoom();
    }
}
