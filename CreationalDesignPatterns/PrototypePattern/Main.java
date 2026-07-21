package CreationalDesignPatterns.PrototypePattern;

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee("Komesh", "Developer");

        Employee e2 = e1.clone();

        System.out.println(e1);

        System.out.println(e2);
    }
}
