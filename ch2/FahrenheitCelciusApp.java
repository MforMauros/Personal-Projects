package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Converts Fahrenheit to Celsius when the user inserts a temperature in Fahrenheit.
 */

public class FahrenheitCelciusApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int celsius = 0;
        int fahrenheit = 0;
        int fahrenheitToCelsius = 0;

        System.out.println("Please insert an integer number of Fahrenheit to convert to Celsius: ");
        fahrenheit = in.nextInt();

        fahrenheitToCelsius = 5 * (fahrenheit-32) / 9;

        System.out.println(fahrenheitToCelsius);






    }
}
