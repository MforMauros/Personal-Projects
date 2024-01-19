package gr.aueb.cf.ch2;

/**
 * User inserts 3 integers that represents day, month, year accordingly and convert in this form: DD/MM/YY.
 */

import java.util.Scanner;

public class DateApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int leftDigitDay;
        int rightDigitDay;
        int leftDigitMonth;
        int rightDigitMonth;
        int yearTrim;

        System.out.println("Please provide an integers that represents day: ");
        num1 = in.nextInt();

        System.out.println("Please provide an integers that represents month: ");
        num2 = in.nextInt();

        System.out.println("Please provide an integers that represents year: ");
        num3 = in.nextInt();

        //Trim the input numbers

        leftDigitDay = num1 /10;
        rightDigitDay = num1 % 10;
        leftDigitMonth = num2 / 10;
        rightDigitMonth = num2 % 10;
        yearTrim = num3 % 100;

        //Print the date

        System.out.printf("The date you entered is %d%d/%d%d/%d" , leftDigitDay, rightDigitDay, leftDigitMonth, rightDigitMonth, yearTrim);

    }
}
