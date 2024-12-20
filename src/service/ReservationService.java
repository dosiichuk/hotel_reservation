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

    public static void createAndAddRoom(String roomNumber, Double price, RoomType roomType) {
        rooms.add(new Room(roomNumber, price, roomType, true));
    }

    public static void addRoom(IRoom room) {
        rooms.add(room);
    }

    public static IRoom getRoom(String roomNumber) {
        for (IRoom room: rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public static void reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            reservations.add(new Reservation(customer, room, checkInDate, checkOutDate));
        } catch (Exception e){
            System.out.println("Failure to create reservation");
        }
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new ArrayList<>();
        for (IRoom room : rooms) {
            boolean isAvailable = true;
            for (Reservation reservation : reservations) {
                if (reservation.getRoom().equals(room) &&
                        !(checkOutDate.before(reservation.getCheckInDate()) || checkInDate.after(reservation.getCheckOutDate()))) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                availableRooms.add(room);
            }

            return availableRooms;
        }
        return availableRooms;
    }

    public static Collection<IRoom> findAllRooms() {
        return rooms;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        return reservations.stream().filter(reservation -> reservation.getCustomer() == customer).toList();
    }

    public static void printAllReservation() {
        for (Reservation reservation: reservations) {
            System.out.println(reservation);
        }
    }
}
