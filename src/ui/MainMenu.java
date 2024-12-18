package ui;

import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public static void takeUserInput(Scanner scanner) {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Find and reserve a room");
                    break;
                case 2:
                    System.out.println("See my reservations");
                    break;
                case 3:
                    createAccount(scanner);
                    break;
                case 4:
                    AdminMenu.takeUserInput(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("---------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("---------------------------");
        System.out.println("Please select a number for the menu option");
    }

    public static void createAccount(Scanner scanner) {
        System.out.println("Enter your email address");
        String email = scanner.nextLine();
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static void findAndReserveRoom(Scanner scanner) {
        System.out.println("Enter check-in date mm/dd/yyyy example 01/01/2024");
        String checkInInput = scanner.nextLine();
        System.out.println("Enter check-out date mm/dd/yyyy example 01/01/2024");
        String checkOutInput = scanner.nextLine();
        Date checkInDate;
        Date checkOutDate;
        try {
            checkInDate = new SimpleDateFormat("MM/dd/yyyy").parse(checkInInput);
            checkOutDate = new SimpleDateFormat("MM/dd/yyyy").parse(checkOutInput);
        } catch (Exception e) {
            System.out.println("Invalid date format");
            return;
        }
        Collection<IRoom> availableRooms = ReservationService.findRooms(checkInDate, checkOutDate);
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available for the selected dates");
            return;
        }
        System.out.println("Available rooms:");
        for (IRoom room : availableRooms) {
            System.out.println(room);
        }
        System.out.println("Would you like to reserve a room? (y/n)");
        String reserve = scanner.nextLine();
        if (!reserve.equals("y") && !reserve.equals("n")) {
            System.out.println("Invalid input");
            return;
        }
        if (reserve.equals("n")) {
            return;
        }
        System.out.println("Do you have an account? (y/n)");
        String hasAccount = scanner.nextLine();



    }


}
