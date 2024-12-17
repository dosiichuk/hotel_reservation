package ui;

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
                    System.out.println("Create an account");
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
        System.out.println("\n---------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("---------------------------");
        System.out.println("Please select a number for the menu option");
    }


}
