package Collections;

    import java.util.HashMap;

    public class MapBasics {
        public static void main(String[] args) {
            HashMap<String, String> capitalsMap = new HashMap<>();

            capitalsMap.put("USA", "Washington D.C.");
            capitalsMap.put("France", "Paris");
            capitalsMap.put("Japan", "Tokyo");

            System.out.println("HashMap of countries and capitals:");
            for (String country : capitalsMap.keySet()) {
                String capital = capitalsMap.get(country);
                System.out.println("Capital of " + country + " is " + capital);
            }
        }
    }


