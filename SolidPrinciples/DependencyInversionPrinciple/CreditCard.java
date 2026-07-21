package SolidPrinciples.DependencyInversionPrinciple;

class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Credit Card");
    }
}
