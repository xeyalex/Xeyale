package Multitreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

    public class SumUsingMultipleThreads {
        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int numThreads = 4; // Number of threads

            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

             int chunkSize = (int) Math.ceil((double) array.length / numThreads);

            // Submit tasks for each chunk
            for (int i = 0; i < numThreads; i++) {
                int start = i * chunkSize;
                int end = Math.min((i + 1) * chunkSize, array.length);
                executor.submit(new SumTask(array, start, end));
            }

           executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class SumTask implements Runnable {
        private int[] array;
        private int start;
        private int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            System.out.println("Sum of elements from index " + start + " to " + (end - 1) + " is: " + sum);
        }
    }

