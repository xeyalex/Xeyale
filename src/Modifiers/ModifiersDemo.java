package Modifiers;

public class ModifiersDemo {

    public static void main(String[] args) {
        Person person = new Person("James", 68, 1.80, "male");

        person.method1();
        person.method2();
        person.method3();
        person.method4();


        System.out.println("Total Person Count: " + Person.totalPersonCount);
    }
}


