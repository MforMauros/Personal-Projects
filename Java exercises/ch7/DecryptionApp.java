package gr.aueb.cf.ch7;

import java.util.Scanner;

public class DecryptionApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to decrypt:");
        String s = sc.nextLine();

        String decryptedString = decryptString(s);
        System.out.println("Decrypted String: " + decryptedString);
    }


    public static String decryptString(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            decrypted.append((char) (c - 1));
        }
        return decrypted.toString();
    }
}
