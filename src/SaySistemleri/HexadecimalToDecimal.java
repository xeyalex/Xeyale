package SaySistemleri;


import java.util.Scanner;

    public class HexadecimalToDecimal {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a hexadecimal number: ");
            String hexString = scanner.nextLine();

            int decimal = Integer.parseInt(hexString, 16);

            System.out.println("Decimal equivalent: " + decimal);
        }
    }

