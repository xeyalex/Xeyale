package SaySistemleri;

import java.util.Scanner;

    public class BinaryToDecimal {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a binary number: ");
            String binaryString = scanner.nextLine();

            int decimal = Integer.parseInt(binaryString, 2);

            System.out.println("Decimal equivalent: " + decimal);
        }
    }


