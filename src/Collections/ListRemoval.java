package Collections;

    import java.util.ArrayList;

    public class ListRemoval {
        public static void main(String[] args) {
            ArrayList<String> list = new ArrayList<>();
            list.add("Apple");
            list.add("Banana");
            list.add("Orange");

            int indexToRemove = 1;
            if (indexToRemove >= 0 && indexToRemove < list.size()) {
                list.remove(indexToRemove);
            }

            System.out.println("Updated ArrayList after removal:");
            System.out.println(list);
        }
    }


