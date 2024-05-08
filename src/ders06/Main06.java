package ders06;

public class Main06 {
    public static void main(String[] args) {
        Person itHero = new Person();
        itHero.age = 29;
        itHero.name = "Xeyale";
        SalaryCalculator calculator = new SalaryCalculator();
        System.out.println("evvel " + itHero.salary);
        calculator.calculatePersonSalary(itHero);
        System.out.println("sonra " + itHero.salary);

        int a = 10;
        calculator.multiplyThis(a);
        System.out.println(a);


    }
}
