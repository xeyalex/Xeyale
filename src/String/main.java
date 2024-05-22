package String;

public class main {
    public static void main(String[] args) {

        String name = "Məhərrəm";
        System.out.println("1. name dəyişənin dəyəri: " + name);

        String message = "Java dilini öyrənmək maraqlı və faydalıdır";
        System.out.println("2. message dəyişənin dəyəri: " + message);

        int messageLength = message.length();
        System.out.println("3. message dəyişənində olan simvol sayı: " + messageLength);

        char seventhChar = message.charAt(6);
        System.out.println("4. message dəyişənindəki 7-ci simvol: " + seventhChar);

        int indexOfN = message.indexOf('n');
        System.out.println("5. 'n' simvolunun indeksi: " + indexOfN);

        String lowercaseMessage = message.toLowerCase();
        System.out.println("6. message dəyişəninin kiçik hərflərlə dəyəri: " + lowercaseMessage);

        String uppercaseMessage = message.toUpperCase();
        System.out.println("7. message dəyişəninin böyük hərflərlə dəyəri: " + uppercaseMessage);

        boolean containsChar = message.contains("f");
        System.out.println("8. message dəyişənində 'f' simvolu var: " + containsChar);

        boolean endsWithLine = message.endsWith("dır");
        System.out.println("9. message dəyişənində sətir ilə bitir: " + endsWithLine);

        boolean startsWithLine = message.startsWith("Java");
        System.out.println("10. message dəyişənində sətir ilə başlayır: " + startsWithLine);

        name = "Ayxan";
        System.out.println("11. name dəyişəninə yeni dəyər mənimsədildi: " + name);

        String trimmedMessage = message.trim();
        System.out.println("12. message dəyişəninə boşluqlar aradan qaldırıldı: " + trimmedMessage);

        name = "Kamil";
        System.out.println("13. name dəyişəninə yeni dəyər mənimsədildi: " + name);

        String firstFourChars = message.substring(0, 4);
        System.out.println("14. message dəyişəninin ilk 4 simvolu: " + firstFourChars);

        name = "Hüseyn Mehdizadə";
        System.out.println("15. name dəyişəninə yeni dəyər mənimsədildi: " + name);

        String[] parts = message.split(" ");
        System.out.println("16. message dəyişəninin bölünmüş massivi: ");
        for (String part : parts) {
            System.out.println(part);
//regionMatches
            String s1 = "Developia";
            String s2 = "Developer";
            System.out.println(s1.regionMatches(0, s2, 0, 5));

        }
    }
}

