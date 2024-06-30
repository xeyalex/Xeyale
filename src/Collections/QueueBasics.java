package Collections;

import java.util.LinkedList;
import java.util.Queue;

    public class QueueBasics {
        public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();

            queue.add("Element 1");
            queue.add("Element 2");
            queue.add("Element 3");

            queue.remove();
            queue.remove();

            System.out.println("Queue elements:");
            for (String element : queue) {
                System.out.println(element);
            }
        }
    }


