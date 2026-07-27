package BehaviouralDesignPatterns.StrategyPattern;

public class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Paid $" + amount + " using UPI");
    }
}
