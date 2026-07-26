package StructuralDesignPatterns.FacadePattern;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        OrderFacade facade = new OrderFacade();
        facade.placeOrder();
    }
}
