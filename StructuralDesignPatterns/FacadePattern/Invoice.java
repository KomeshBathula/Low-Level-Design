package StructuralDesignPatterns.FacadePattern;

public class Invoice {
    
    public void generateInvoice() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Invoice Generated");
    }
}
