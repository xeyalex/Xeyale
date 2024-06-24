package Multitreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

    public class DiningPhilosophers {
        public static void main(String[] args) throws InterruptedException {
            int numPhilosophers = 5;
            Philosopher[] philosophers = new Philosopher[numPhilosophers];
            Fork[] forks = new Fork[numPhilosophers];

                for (int i = 0; i < numPhilosophers; i++) {
                forks[i] = new Fork();
            }

                for (int i = 0; i < numPhilosophers; i++) {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]);
            }


            for (Philosopher philosopher : philosophers) {
                philosopher.start();
            }

            Thread.sleep(10000);
            for (Philosopher philosopher : philosophers) {
                philosopher.stopPhilosopher();
            }
        }
    }
class Fork {
    private Lock lock = new ReentrantLock();

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}



class Philosopher extends Thread {
        private int id;
        private Fork leftFork;
        private Fork rightFork;
        private Lock pickUpOrder = new ReentrantLock();

        public Philosopher(int id, Fork leftFork, Fork rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        public void run() {
            while (true) {
                think();
                eat();
            }
        }

        private void think() {
            System.out.println("Philosopher " + id + " is thinking");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void eat() {
            pickUpOrder.lock();
            leftFork.pickUp();
            rightFork.pickUp();
            pickUpOrder.unlock();

            System.out.println("Philosopher " + id + " is eating");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            leftFork.putDown();
            rightFork.putDown();
        }

        public void stopPhilosopher() {
            this.interrupt();
        }
    }

