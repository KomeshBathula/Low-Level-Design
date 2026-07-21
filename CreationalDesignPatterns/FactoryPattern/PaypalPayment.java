package CreationalDesignPatterns.FactoryPattern;

public class PaypalPayment implements Payment{
    public void pay(double amount) {
        System.out.println("Amount paid using paypal");
    }
}
