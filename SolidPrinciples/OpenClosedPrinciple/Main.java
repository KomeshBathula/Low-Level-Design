package SolidPrinciples.OpenClosedPrinciple;

public class Main {
    public static void main(String[] args) {
        PaymentService payment = new PaymentService(new CreditCardPayment());

        payment.processPayment(5000);
    }   
}
