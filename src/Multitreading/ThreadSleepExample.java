package Multitreading;

public class ThreadSleepExample {
        public static void main(String[] args) {
            Thread thread = new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


