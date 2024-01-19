package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * εκτυπώνει αστεράκια κάθετα σύμφωνα με
 * τα n αστεράκια που δίνει ο χρήστης με το stdn
 */
public class VerticalStars {
    public static void main(String[] args) {
        int n = 0;

        // ζηταμε από τον χρήστη να δώσει ακέραιο αριθμό αστεριών
        Scanner in = new Scanner(System.in);
        System.out.print("Please give the number of stars:");
        n = in.nextInt();

        //εκτυπώνουμε τα αστέρια κάθετα n φορές
        for (int i = 1; i <= n; i++) {
            System.out.println("*");
        }
    }
}
