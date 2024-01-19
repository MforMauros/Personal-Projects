package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * encrypts string characters with the next ascii character
 */
public class EncryptionApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to encrypt:");
        String s = sc.nextLine();

        String encryptedString = encryptString(s);
        System.out.println("Encrypted String: " + encryptedString);
    }

    public static String encryptString(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + 1));
        }
        return encrypted.toString();
    }

}
