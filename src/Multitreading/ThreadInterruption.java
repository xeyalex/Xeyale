package Multitreading;

public class ThreadInterruption {
           public static void main(String[] args) {
            Thread taskThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Task is running...");
                        Thread.sleep(1000);
                        if (Thread.interrupted()) {
                            System.out.println("Thread interrupted.");
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted via exception.");
                }
            });

            taskThread.start();
            try {
                Thread.sleep(5000);
                taskThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

