package HomeWork06;

public class MainClass {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        myCircle.radius = 7;

        Calculator calculator = new Calculator();

        calculator.calculateCircleLength(myCircle);

        System.out.println("Circle Length: " + myCircle.length);
    }
}
