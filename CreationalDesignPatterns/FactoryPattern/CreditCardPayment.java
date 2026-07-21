package CreationalDesignPatterns.FactoryPattern;

public class CreditCardPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Amount paid using Credit card");
    }
}
