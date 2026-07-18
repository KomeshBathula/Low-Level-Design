package SolidPrinciples.OCP;

public class PaymentService {
    private PaymentMethod paymentMethod;

    PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}
