package Multitreading;

    public class HelloThreads {
        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                System.out.print("Hello ");
            });

            Thread thread2 = new Thread(() -> {
                System.out.println("World");
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


