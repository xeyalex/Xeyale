package Collections;

    import java.util.ArrayList;

    public class ListIteration {
        public static void main(String[] args) {
            ArrayList<String> namesList = new ArrayList<>();
            namesList.add("James");
            namesList.add("Gosling");
            namesList.add("Java");
            namesList.add("Elina");
            namesList.add("Eva");

           System.out.println("Names in the ArrayList:");
            for (String name : namesList) {
                System.out.println(name);
            }
        }
    }


