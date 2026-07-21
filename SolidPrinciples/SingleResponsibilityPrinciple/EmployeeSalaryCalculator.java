public class EmployeeSalaryCalculator {

    public double bonusSalary(Employee emp) {
        double baseSalary = emp.getBaseSalary();

        double bonus = baseSalary * 0.1;

        return baseSalary + bonus;
    }
}
