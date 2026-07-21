package CreationalDesignPatterns.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.createPayment("credit");
        payment.pay(4000);

        Payment payment2 = PaymentFactory.createPayment("upi");
        payment2.pay(500000);
    }
}
