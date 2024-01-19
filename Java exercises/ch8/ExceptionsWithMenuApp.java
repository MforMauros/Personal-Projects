package gr.aueb.cf.ch8;

import java.util.Scanner;

public class ExceptionsWithMenuApp {

    public static void main(String[] args) {

        int choice = 0;
        while (true) {
            displayMenu();
            try {
                choice = getChoice();
                if (choice == 5) {
                    System.out.println("Thank's For using our app");
                    System.exit(0);
                }
                printChoice(choice);


            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number.Please insert an integer between 1 to 5 (5 for exit)");
            }
        }

    }

    public static void displayMenu() {
        System.out.println("Please choose one of the choices below:");
        System.out.println("1. Input");
        System.out.println("2. Delete");
        System.out.println("3. Update");
        System.out.println("4. Search");
        System.out.println("5. Exit");
    }

    public static int getChoice() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please insert an integer between 1 to 5 (5 for exit)");
            in.nextLine();
        }
        return in.nextInt();
    }

    public static void printChoice(int choice) throws IllegalArgumentException {

        if (choice > 5 || choice < 1) {
            throw new IllegalArgumentException();
        } else if (choice == 1) {
            System.out.println("You choose input");
        } else if (choice == 2) {
            System.out.println("You choose delete");
        } else if (choice == 3) {
            System.out.println("You choose update");
        } else if (choice == 4) {
            System.out.println("You choose search");
        }
    }

}



