package Modifiers;

class Person {

    public String name;
    private int age;
    protected double height;
    String gender;


    public void method1() {
        System.out.println("Method 1 is public.");
    }

    void method2() {
        System.out.println("Method 2 is private.");
    }

    protected void method3() {
        System.out.println("Method 3 is protected.");
    }

    void method4() {
        System.out.println("Method 4 is default (package-private).");
    }


    public Person(String name) {
        this.name = name;
    }

    private Person(int age) {
        this.age = age;
    }

    protected Person(double height) {
        this.height = height;
    }

    Person(String name, int age, double height, String gender) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.gender = gender;
    }


    public void finalMethod(final String info) {
        System.out.println("Additional Info: " + info);
    }


    public static int totalPersonCount;


}

