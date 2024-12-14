package service;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {
    private Collection<Reservation> reservations =  new ArrayList<>();
    public static void addRoom(IRoom room) {

    }

    public static IRoom getRoom(String roomId) {
        return null;
    }

    public static Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return null;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        return null;
    }

    public void printAllReservation() {

    }
}
