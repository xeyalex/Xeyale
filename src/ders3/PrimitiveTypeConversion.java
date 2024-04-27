package ders3;

public class PrimitiveTypeConversion {
    public static void main(String[] args) {
        short a = 69 ;
        System.out.println(a);
        byte b = (byte) a ;
        System.out.println(b);

        short c = 589 ;
        System.out.println(c);
        byte d = (byte) c ;
        System.out.println(d);

        long e = 458L ;
        System.out.println(e);
        int f = (int) e ;
        System.out.println(f);

        long g = 52523635483L ;
        System.out.println(g);
        int h = (int) g  ;
        System.out.println(h);

        double i = 5632.6 ;
        System.out.println(i);
        int j = (int) i ;
        System.out.println(j);

        char k = 'D' ;
        System.out.println(k);
        int z = (int) k ;
        System.out.println(z);

        int m = 123 ;
        System.out.println(m);
        char o = (char) m ;
        System.out.println(o);




    }
}
