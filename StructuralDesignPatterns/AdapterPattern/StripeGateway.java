package StructuralDesignPatterns.AdapterPattern;

public class StripeGateway {
    
    public void pay(double amount) {
        System.out.println("Stripe Payment: " + amount);
    }
}
