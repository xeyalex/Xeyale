package Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {76, 45, 23, 78, 23, 98, 15};
        boolean swapped = true;
        int counter = 1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < numbers.length - counter; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swapped = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;

                }
            }
            counter++;
        }
        for (int i : numbers) {
            System.out.println(i);
        }
    }
}
