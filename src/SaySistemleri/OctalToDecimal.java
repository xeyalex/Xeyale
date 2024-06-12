package SaySistemleri;

import java.util.Scanner;

public class OctalToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an octal number: ");
        String octalString = scanner.nextLine();

        int decimal = Integer.parseInt(octalString, 8);

        System.out.println("Decimal equivalent: " + decimal);
    }
}
