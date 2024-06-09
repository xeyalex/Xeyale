package Exception;

public class DivideNumbers {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 0;

        try {
            int result = dividend / divisor; // This line may throw ArithmeticException
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
