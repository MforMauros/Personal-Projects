package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * Displays a menu of showing stars
 * and user choose the number of stars (n) he was via stdn
 */
public class StarsApp {

    public static void main(String[] args) {
        int choice = 0;
        int n = 0;

        do {
            displayMenu();
            choice = getUsersChoice();
            if (choice == 6) {
                System.out.println("You chose exit");
                break;
            }
            n = getUsersN();

            switch (choice) {
                case 1:
                    horizontalStars(n);
                    break;
                case 2:
                    verticalStars(n);
                    break;
                case 3:
                    nxnStars(n);
                    break;
                case 4:
                    factorial(n);
                    break;
                case 5:
                    factorialRev(n);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println();
            System.out.print("===================");
            System.out.println();
        } while (true);
        System.out.println("Thanks for using our App!");
    }

    public static void displayMenu() {
        System.out.println("Επιλέξτε ένα από τα παρακάτω:");
        System.out.println("1. Εμφάνισε n αστεράκια οριζόντια:");
        System.out.println("2. Εμφάνισε n αστεράκια κάθετα:");
        System.out.println("3. Εμφάνισε n γραμμές με n αστεράκια:");
        System.out.println("4. Εμφάνισε n γραμμές με αστεράκια 1 – n:");
        System.out.println("5. Εμφάνισε n γραμμές με αστεράκια n – 1:");
        System.out.println("6. Έξοδος από το πρόγραμμα:");
    }

    public static int getUsersN() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the amount of stars that you want");
        return in.nextInt();
    }

    public static int getUsersChoice() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your choice!");

        return in.nextInt();
    }

    public static void horizontalStars(int amountOfN) {
        for (int i = 1; i <= amountOfN; i++) {
            System.out.print("*");
        }
    }

    public static void verticalStars(int amountOfN) {
        for (int i = 1; i <= amountOfN; i++) {
            System.out.println("*");
        }
    }

    public static void nxnStars(int amountOfN) {
        for (int i =1; i <= amountOfN; i++) {
            horizontalStars(amountOfN);
            System.out.println();
        }
    }

    public static void factorial(int amountOfN) {
        for (int i = 1; i <= amountOfN; i++) {
            horizontalStars(i);
            System.out.println();
        }
    }

    public static void factorialRev(int amountOfN) {
        for (int i = 0; i < amountOfN; i++) {
            horizontalStars(amountOfN -i);
            System.out.println();
        }
    }

}
