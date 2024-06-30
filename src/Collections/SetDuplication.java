package Collections;

  import java.util.HashSet;

    public class SetDuplication {
        public static void main(String[] args) {
            HashSet<String> set = new HashSet<>();

            set.add("Apple");
            set.add("Banana");
            set.add("Apple"); // Duplicate

            System.out.println("HashSet with duplicates:");
            System.out.println(set);

        }
    }


