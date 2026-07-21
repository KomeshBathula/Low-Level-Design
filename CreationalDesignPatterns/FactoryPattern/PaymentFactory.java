package CreationalDesignPatterns.FactoryPattern;

public class PaymentFactory {
    public static Payment createPayment(String type) {
        if (type == "credit") 
            return new CreditCardPayment();
        else if (type == "upi")
            return new UPIPayment();
        else if (type == "paypal")
            return new PaypalPayment();
        throw new IllegalArgumentException("Invalid payment type");
    }
}
