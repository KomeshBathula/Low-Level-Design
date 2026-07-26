package StructuralDesignPatterns.FacadePattern;

public class Payment {
    
    public void processPayment() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Payment successful");
    }
}
