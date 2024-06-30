package Collections;
  import java.util.HashSet;

    public class SetBasics {
        public static void main(String[] args) {
             HashSet<String> fruitsSet = new HashSet<>();

            fruitsSet.add("Apple");
            fruitsSet.add("Banana");
            fruitsSet.add("Orange");
            fruitsSet.add("Grapes");
            fruitsSet.add("Pineapple");

            System.out.println("HashSet of fruits:");
            System.out.println(fruitsSet);
        }
    }


