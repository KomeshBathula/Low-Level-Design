public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Komesh", "komesh@gmail.com",1000000);

        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.save(emp);

        EmployeeSalaryCalculator empSalary = new EmployeeSalaryCalculator();
        double finalSalary = empSalary.bonusSalary(emp);

        EmployeeReportGenerator empReport = new EmployeeReportGenerator();
        empReport.displayEmployeeDetails(emp);

        EmployeeNotificationService empNotification = new EmployeeNotificationService();
        empNotification.sendSalaryNotification(emp, finalSalary);
    }
}
