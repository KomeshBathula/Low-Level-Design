package StructuralDesignPatterns.AdapterPattern;

public class Main {
    public static void main(String[] args) {
        PaymentService stripe = new PaymentService(new StripeAdapter(new StripeGateway()));

        stripe.checkout(5000);

        PaymentService razorpay = new PaymentService(new RazorpayAdapter(new RazorpayGateway()));

        razorpay.checkout(10000);
    }
}
