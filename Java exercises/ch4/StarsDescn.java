package gr.aueb.cf.ch4;

import java.util.Scanner;
/**
 * Εκτυπώνει n αστερια στην πρώτη σειρά
 * n-1 στη δευτερη και ούτω καθεξής για n σειρές.
 * όπου n το δίνει ο χρήστης με stdn
 */
public class StarsDescn {
    public static void main(String[] args) {
        int n = 0;

        // ζηταμε από τον χρήστη να δώσει ακέραιο αριθμό σειρών αστεριών
        Scanner in = new Scanner(System.in);
        System.out.print("Please give the number of stars rows:");
        n = in.nextInt();

        //εκτυπώνουμε τα αστέρια ανάλογα με το n που έδωσε ο χρήστης discentic
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n -i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
