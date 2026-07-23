package StructuralDesignPatterns.AdapterPattern;

public class RazorpayGateway {
    
    public void makePayment(double value) {
        System.out.println("Razorpay payment: " + value);
    }
}
