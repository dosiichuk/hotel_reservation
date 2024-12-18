package ui;

import api.AdminResource;
import model.customer.Customer;
import model.room.IRoom;
import model.room.RoomType;

import java.util.Collection;
import java.util.Scanner;

public class AdminMenu {

    public static void takeUserInput(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            int userInput = Integer.parseInt(scanner.nextLine());
            switch (userInput) {
                case 1:
                    Collection<Customer> customers = AdminResource.getAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    Collection<IRoom> rooms = AdminResource.getAllRooms();
                    for (IRoom room : rooms) {
                        System.out.println(room);
                    }
                    break;
                case 3:
                    System.out.println("All reservations:");
                    break;
                case 4:
                    addRoom(scanner);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Admin Menu");
        System.out.println("---------------------------");
        System.out.println("1. See all customers");
        System.out.println("2. See all rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a room");
        System.out.println("5. Back to Main Menu");
        System.out.println("---------------------------");
        System.out.println("Please select a number for the menu option");
    }

    public static void addRoom(Scanner scanner) {
        System.out.println("Enter room number");
        String roomNumber = scanner.nextLine();
        System.out.println("Enter price per night");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter room type (1 for single bed, 2 for double bed)");
        int roomType = Integer.parseInt(scanner.nextLine());
        AdminResource.addRoom(roomNumber, price, RoomType.getRoomType(roomType));
        System.out.println("Would you like to add another room? (y/n)");
        String response = scanner.nextLine();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please enter 'Y' (Yes) or 'N' (No)");
            response = scanner.nextLine();
        }
        if (response.equals("y")) {
            addRoom(scanner);
        }
    }
}
