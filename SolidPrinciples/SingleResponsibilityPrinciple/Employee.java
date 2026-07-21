public class Employee {
    private String name;
    private String email;
    private double baseSalary;

    Employee(String name, String email, double baseSalary) {
        setName(name);
        setEmail(email);
        setBaseSalary(baseSalary);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

}