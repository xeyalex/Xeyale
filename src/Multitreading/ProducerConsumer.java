package Multitreading;

   import java.util.LinkedList;

    public class ProducerConsumer {
        public static void main(String[] args) {
            Buffer buffer = new Buffer(5);

               Thread producerThread = new Thread(() -> {
                try {
                    buffer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread consumerThread = new Thread(() -> {
                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            producerThread.start();
            consumerThread.start();

                try {
                producerThread.join();
                consumerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Buffer {
        private LinkedList<Integer> list;
        private int capacity;

        public Buffer(int capacity) {
            this.list = new LinkedList<>();
            this.capacity = capacity;
        }

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    while (list.size() == capacity) {
                        wait();
                    }

                    System.out.println("Producer produced: " + value);
                    list.add(value++);

                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (list.size() == 0) {
                        wait();
                    }

                    int consumedValue = list.removeFirst();
                    System.out.println("Consumer consumed: " + consumedValue);

                    notify();
                    Thread.sleep(1000); // Simulate some delay
                }
            }
        }
    }

