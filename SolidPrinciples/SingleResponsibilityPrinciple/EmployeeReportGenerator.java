public class EmployeeReportGenerator {

    public void displayEmployeeDetails(Employee emp) {
        System.out.println("Employee Report");
        System.out.println("Name: "+emp.getName());
        System.out.println("Email: "+emp.getEmail());
        System.out.println("Base Salary: "+emp.getBaseSalary());
    }
}
