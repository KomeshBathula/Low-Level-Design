package StructuralDesignPatterns.FacadePattern;

public class Inventory {
    
    public boolean checkStock() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Checking stock... ");
        return true;
    }
}
