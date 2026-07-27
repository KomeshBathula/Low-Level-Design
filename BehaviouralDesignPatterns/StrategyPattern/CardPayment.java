package BehaviouralDesignPatterns.StrategyPattern;

public class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Paid $" + amount + " using Credit Card");
    }
}
