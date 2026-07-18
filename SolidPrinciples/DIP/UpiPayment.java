package SolidPrinciples.DIP;

class UpiPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using UPI");
    }
}