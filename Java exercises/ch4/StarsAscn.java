package gr.aueb.cf.ch4;

import java.util.Scanner;
/**
 * Εκτυπώνει 1 αστερι στην πρώτη σειρά
 * 2 στη δευτερη και ούτω καθεξής έως
 * τη σειρά n αναλογικά. όπου n το δίνει ο χρήστης με stdn
 */
public class StarsAscn {
    public static void main(String[] args) {
        int n = 0;

        // ζηταμε από τον χρήστη να δώσει ακέραιο αριθμό σειρών αστεριών
        Scanner in = new Scanner(System.in);
        System.out.print("Please give the number of stars rows:");
        n = in.nextInt();

        //εκτυπώνουμε τα αστέρια ανάλογα με το n που έδωσε ο χρήστης ascentic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
