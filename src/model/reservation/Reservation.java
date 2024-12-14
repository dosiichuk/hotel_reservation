package model.reservation;

import model.customer.Customer;
import model.room.IRoom;

import java.util.Date;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", room=" + room +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reservation)) {
            return false;
        }
        Reservation reservation = (Reservation) obj;
        return customer.equals(reservation.customer) && room.equals(reservation.room) && checkInDate.equals(reservation.checkInDate) && checkOutDate.equals(reservation.checkOutDate);
    }

    @Override
    public int hashCode() {
        int result = customer.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + checkInDate.hashCode();
        result = 31 * result + checkOutDate.hashCode();
        return result;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
}
