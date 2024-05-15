package Arrays;

public class ArraysDemoHome {
    public static void main(String[] args) {
           int[] numbers = {10, 20, 30, 40};

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Massivin bütün elementlərinin cəmi: " + sum);

                System.out.println("Massivin elementləri:");
        for (int num : numbers) {
            System.out.println(num);
        }

        double average = sum / (double) numbers.length;
        System.out.println("Massivin ədədi ortası: " + average);

        int min = numbers[0];
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Massivin ən kiçik elementi: " + min);
        System.out.println("Massivin ən böyük elementi: " + max);

        System.out.println("Tək elementlər:");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.println(num);
            }
        }
        System.out.println("Cüt elementlər:");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }

        System.out.println("Sadə ədədlər:");
        for (int num : numbers) {
            boolean isPrime = true;
            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.println(num);
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        System.out.println("Sıralanmış massiv:");
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}

