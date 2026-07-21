package CreationalDesignPatterns.FactoryPattern;

public class UPIPayment implements Payment{
    public void pay(double amount) {
        System.out.println("Amount paid using UPI");
    }
}
