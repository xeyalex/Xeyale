package Collections;

import java.util.HashMap;

public class MapLookup {
        public static void main(String[] args) {
            HashMap<String, String> capitalsMap = new HashMap<>();
            capitalsMap.put("USA", "Washington");
            capitalsMap.put("France", "Paris");
            capitalsMap.put("Japan", "Tokyo");

            String country = "France";
            String capital = capitalsMap.get(country);
            System.out.println("Capital of " + country + " is " + capital);
        }
    }


