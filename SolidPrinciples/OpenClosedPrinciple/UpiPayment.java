package SolidPrinciples.OpenClosedPrinciple;

public class UpiPayment implements PaymentMethod{
    public void pay(double amount) {
        System.out.println("Amount paid using upi");
    }
}
