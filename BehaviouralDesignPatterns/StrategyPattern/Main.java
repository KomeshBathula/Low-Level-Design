package BehaviouralDesignPatterns.StrategyPattern;

public class Main {

    public static void main(String[] args) {

        PaymentService payment =
                new PaymentService(new UpiPayment());

        payment.makePayment(500);

        payment.setStrategy(new CardPayment());

        payment.makePayment(1000);

        payment.setStrategy(new PaypalPayment());

        payment.makePayment(2000);
    }
}