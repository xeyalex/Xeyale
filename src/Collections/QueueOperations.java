package Collections;

   import java.util.PriorityQueue;

    public class QueueOperations {
        public static void main(String[] args) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            queue.add(5);
            queue.add(1);
            queue.add(3);

           System.out.println("PriorityQueue elements:");
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
        }
    }


