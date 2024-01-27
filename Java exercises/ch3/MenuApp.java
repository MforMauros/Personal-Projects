package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Shows a menu and takes an input from
 * user to decide which one to pick.
 * When the user choose 5, it exits the loop.
 */
public class MenuApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choise = 0;

        do {
            System.out.println("Please choose one of the choices below:");
            System.out.println("1. Input");
            System.out.println("2. Delete");
            System.out.println("3. Update");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            choise = scanner.nextInt();
            if (choise == 1) {
                System.out.println("You choose input");
            } else if (choise == 2) {
                System.out.println("You choose delete");
            } else if (choise == 3) {
                System.out.println("You choose update");
            } else if (choise == 4) {
                System.out.println("You choose search");
            } else if (choise == 5) {
                System.out.println("You choose exit");
            } else {
                System.out.println("You have to choose from 1 to 5");
            }
        } while (choise !=5);
        System.out.println("Thanks for using our app");
    }
}
