package gr.aueb.cf.ch6;

import java.util.Arrays;
import java.util.Scanner;

public class PredicatesApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[6];

        System.out.println("Please enter 6 integers from 1 to 49: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Please enter integers No: " + (i + 1));
            numbers[i] = in.nextInt();
        }

        if (validationLimits(numbers)) {
            if (even3(numbers)) {
                System.out.println("Your numbers have more that 3 evens. Try again");
            }
            if (odd3(numbers)) {
                System.out.println("Your numbers have more that 3 odds. Try again");
            }
            if (row3(numbers)) {
                System.out.println("Your numbers have more that 3 numbers in a row. Try again");
            }
            if (has3Endings(numbers)) {
                System.out.println("Your numbers have more that 3 numbers with the same ending. Try again");
            }
            if (has3Starts(numbers)) {
                System.out.println("Your numbers have more that 3 numbers with the same start. Try again");
            }
        } else {
            System.out.println("The limits are 1 to 49. Try again");
        }


    }

    public static boolean validationLimits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > 49) {
                return false;
            }
        }
        return true;
    }

    public static boolean even3 (int[] arr) {
        if (arr == null) return false;
        boolean isEven = false;
        int counter = 0;

        for (int j : arr) {
            if ((j % 2) == 0) {
                counter++;
                if (counter > 3) {
                    isEven = true;
                    break;
                }
            }
        }
        return isEven;
    }

    public static boolean odd3 (int[] arr) {
        if (arr == null) return false;
        boolean isOdd = false;
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2) != 0) {
                counter++;
                if (counter > 3) {
                    isOdd = true;
                    break;
                }

            }
        }
        return isOdd;
    }

    public static boolean row3 (int[] arr) {
        if (arr == null) return false;
        boolean isRow3 = false;
        int counter = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i]== arr[i + 1] -1) && (arr[i] == arr[i + 2] - 2)) {
                    isRow3 = true;
                    break;
            }
        }
        return isRow3;
    }

    public static boolean has3Endings (int[] arr) {
        if (arr == null) return false;
        boolean hasSameEndings = false;
        int[] endings = new int[10];

        for (int j : arr) {
            endings[j % 10]++;
        }
        for (int item : endings) {
            if (item > 3) {
                hasSameEndings = true;
                break;
            }
        }
        return hasSameEndings;
    }

    public static boolean has3Starts (int[] arr) {
        if (arr == null) return false;
        boolean hasSameStarts = false;
        int[] starts = new int[10];
        int counter = 0;

        for (int j : arr) {
            starts[j / 10]++;
        }
        for (int item : starts) {
            if (item > 3) {
                hasSameStarts = true;
                break;
            }
        }
        return hasSameStarts;
    }

}
