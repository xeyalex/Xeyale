package String;

import java.util.Random;

public class hw2 {
    public static void main(String[] args) {
//1
        char[] massiv = {'J', 'a', 'm', 'e', 's'};
        String massivString = new String(massiv);
        System.out.println(massivString);
//2
        String p = "jvm";
        String pattern = "[a-z]{3}";
        System.out.println( p.matches(pattern));
//3
        String c = " ";
        System.out.println(c.isEmpty());
        System.out.println(c.isBlank());
//4
        String w = "BMW";
        String l = "KIA";
        boolean res = (w.endsWith(l));
        System.out.println(res);

//5
        Random r = new Random();
        System.out.println(r.nextInt(21) + 10);


//6
        double d = 763.6888;
        String result = String.format("%.2f", d);
        System.out.println(result);



    }
}



