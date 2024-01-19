package gr.aueb.cf.ch4;

import java.util.Scanner;
/**
 * εκτυπώνει αστεράκια οριζόντια σύμφωνα με
 * τα n αστεράκια που δίνει ο χρήστης με το stdn
 */
public class HorizontalStars {
    public static void main(String[] args) {
        int n = 0;

        // ζηταμε από τον χρήστη να δώσει ακέραιο αριθμό αστεριών
        Scanner in = new Scanner(System.in);
        System.out.print("Please give the number of stars:");
        n = in.nextInt();

        //εκτυπώνουμε τα αστέρια οριζόντια n φορές
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
    }
}
