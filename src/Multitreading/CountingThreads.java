package Multitreading;

    public class CountingThreads {
        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 6; i <= 10; i++) {
                    System.out.print(i + " ");
                }
            });

            thread1.start();
            thread2.start();

                try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


