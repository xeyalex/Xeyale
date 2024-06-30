package Collections;

import java.util.ArrayList;
import java.util.HashSet;

    public class SetConversion {
        public static void main(String[] args) {
            HashSet<String> set = new HashSet<>();
            set.add("Apple");
            set.add("Banana");
            set.add("Orange");

            ArrayList<String> list = new ArrayList<>(set);

            System.out.println("Converted ArrayList from HashSet:");
            System.out.println(list);
        }
    }


