package SolidPrinciples.OpenClosedPrinciple;

public class CreditCardPayment implements PaymentMethod{
    public void pay(double amount) {
        System.out.println("Amount paid using credit card");
    }
}
