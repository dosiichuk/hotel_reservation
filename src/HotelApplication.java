import ui.MainMenu;

import java.util.Scanner;

public class HotelApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Hotel Reservation Application");
        MainMenu.getInstance().takeUserInput(scanner);
    }
}