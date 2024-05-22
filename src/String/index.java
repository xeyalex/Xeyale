package String;

public class index {
    public static void main(String[] args) {
        String cumle = "James yazib ki java ni yazib ki yazaq kodu isledekki";
        String soz ="yaz";
        int count = 0;
        int index = -1;
        do {
            index = cumle.indexOf(soz, index+1);
            if(index==-1)break;
            count++;
            System.out.println(index);
        }while (index!=-1);
        System.out.println("say=" +count);
    }
}
