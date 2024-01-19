package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Εκτυπώνει n αστερακια * n σειρές
 * όπου το n το δίνει ο χρήστης
 * με stdn
 */
public class NxnStars {
    public static void main(String[] args) {
        int n = 0;

        // ζηταμε από τον χρήστη να δώσει ακέραιο αριθμό αστεριών
        Scanner in = new Scanner(System.in);
        System.out.print("Please give the number of stars:");
        n = in.nextInt();

        //εκτυπώνουμε τα αστέρια n φορές σε n γραμμές
        for (int i =1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
