package CreationalDesignPatterns.PrototypePattern;

public class Employee implements Prototype<Employee> {

    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public Employee clone() {
        return new Employee(this.name, this.department);
    }

    @Override
    public String toString() {
        return name + " - " + department;
    }
}
