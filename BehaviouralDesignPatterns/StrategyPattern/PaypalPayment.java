package BehaviouralDesignPatterns.StrategyPattern;

public class PaypalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Paid $" + amount + " using PayPal");
    }
}
