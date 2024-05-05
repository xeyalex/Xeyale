public class SadeNumbers {
    public static void main(String[] args) {
            int a = 6; // sade eded sayi
            int c = 0; // saygac
            int b = 2; // sade eded 2den bashlayir
            boolean sadedir=true;
            while (c < a) {
                sadedir=true;
                for (int i = 2; i < b; i++) {
                    if (b % i == 0) {
                        sadedir=false;
                        break;
                    }
                }

                if (sadedir) {
                    c++;
                    System.out.println(b);
                }else{
                    System.out.println("murekkeb imis - "+b);
                }

                b++;
            }
        }
    }


