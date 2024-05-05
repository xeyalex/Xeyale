package ders5;

public class ClassAndObjectHome {
    public static void main(String[] args) {

        Person person1 = new Person();
        Person person2 = new Person();
        person1.id = 1;
        person1.name = "Xəyalə";
        person1.surname = "Qədirova";
        person1.age = 29;
        person1.phone = "95401041995 ";

        person2.id = 2;
        person2.name = "James";
        person2.surname = "Gosling";
        person2.age = 68;
        person2.phone = "9528708948";

        System.out.println("Person 1:");
        System.out.println("ID: " + person1.id);
        System.out.println("Name: " + person1.name);
        System.out.println("Surname: " + person1.surname);
        System.out.println("Age: " + person1.age);
        System.out.println("Phone: " + person1.phone);

        System.out.println("Person 2:");
        System.out.println("ID: " + person2.id);
        System.out.println("Name: " + person2.name);
        System.out.println("Surname: " + person2.surname);
        System.out.println("Age: " + person2.age);
        System.out.println("Phone: " + person2.phone);
    }
}



