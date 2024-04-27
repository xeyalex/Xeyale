package ders3;

public class PrimitiveTypeConversion {
    public static void main(String[] args) {
        short a = 69 ;
        byte b = (byte) a ;
        System.out.println(b);

        short c = 589 ;
        byte d = (byte) c ;
        System.out.println( c);

        long e = 458L ;
        int f = (int) e ;
        System.out.println(e);

        long g = 52523635483L;
        int h = (int) g ;
        System.out.println(g);

        double i = 5632.6 ;
        float j = (float) i ;
        System.out.println(i);

        char k = 'D' ;
        int l = (int) k ;
        System.out.println(k);

        int m = 123 ;
        char n = (char) m ;
        System.out.println(m);




    }
}
