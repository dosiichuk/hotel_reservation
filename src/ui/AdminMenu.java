package ui;

import api.AdminResource;
import api.HotelResource;
import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import model.room.RoomType;

import java.util.Collection;
import java.util.Scanner;

public class AdminMenu {

    private static final AdminMenu instance = new AdminMenu();
    private final AdminResource adminResource = AdminResource.getInstance();
    private final HotelResource hotelResource = HotelResource.getInstance();

    private AdminMenu() {
    }

    public void takeUserInput(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        seeAllCustomers();
                        break;
                    case 2:
                        seeAllRooms();
                        break;
                    case 3:
                        seeAllReservations();
                        break;
                    case 4:
                        addRoom(scanner);
                        break;
                    case 5:
                        isRunning = false;
                        break;
                    case 6:
                        adminResource.populateData();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    public void displayMenu() {
        System.out.println("Admin Menu");
        System.out.println("---------------------------");
        System.out.println("1. See all customers");
        System.out.println("2. See all rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a room");
        System.out.println("5. Back to Main Menu");
        System.out.println("6. Populate the app with test data");
        System.out.println("---------------------------");
        System.out.println("Please select a number for the menu option");
    }

    public void addRoom(Scanner scanner) {
        System.out.println("Enter room number");
        String roomNumber = scanner.nextLine();
        if (hotelResource.getRoom(roomNumber) != null) {
            System.out.println("Room already exists");
            return;
        }
        System.out.println("Enter price per night");
        Double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Price must be a number");
            return;
        }
        System.out.println("Enter room type (1 for single bed, 2 for double bed)");
        int roomType;
        try {
            roomType = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Room type must be a number");
            return;
        }
        try {
            adminResource.addRoom(roomNumber, price, roomType);
            System.out.println("Room added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Would you like to add another room? (y/n)");
        String response = scanner.nextLine().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please enter 'Y' (Yes) or 'N' (No)");
            response = scanner.nextLine();
        }
        if (response.equals("y")) {
            addRoom(scanner);
        }
    }

    public void seeAllReservations() {
        Collection<Reservation> reservations = adminResource.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found");
            return;
        }
        System.out.println("All reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public void seeAllCustomers() {
        Collection<Customer> customers = adminResource.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found");
            return;
        }
        System.out.println("All customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void seeAllRooms() {
        Collection<IRoom> rooms = adminResource.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found");
            return;
        }
        System.out.println("All rooms:");
        for (IRoom room : rooms) {
            System.out.println(room);
        }
    }

    public static AdminMenu getInstance() {
        return instance;
    }
}
