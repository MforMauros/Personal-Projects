package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Takes a stdin from user and return if the year
 * that user provided is Bisect or not
 */
public class ΒisectApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearInput;
        int bisectYear;

        System.out.println("Please insert a year to find out if it is bisect or not!");
        yearInput = scanner.nextInt();

        //calculates if the input year is bisect
        if ((yearInput % 4 == 0 && yearInput % 100 != 0) || (yearInput % 400 ==0)) {
            bisectYear = yearInput;
            System.out.println("The year you entered is bisect");
        } else {
            System.out.println("The year toy entered is NOT bisect");
        }
    }
}
