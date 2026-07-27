package BehaviouralDesignPatterns.StrategyPattern;

public class PaymentService {

    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {

        strategy.pay(amount);
    }
}
