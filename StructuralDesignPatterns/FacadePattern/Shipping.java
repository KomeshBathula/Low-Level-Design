package StructuralDesignPatterns.FacadePattern;

public class Shipping {
    
    public void shipOrder() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Shipping Order");
    }
}
