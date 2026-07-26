package StructuralDesignPatterns.FacadePattern;

public class OrderFacade {
    
    private Inventory inventory;
    private Payment payment;
    private Shipping shipping;
    private Invoice invoice;
    private Notification notification;

    public OrderFacade() {
        inventory = new Inventory();
        payment = new Payment();
        shipping = new Shipping();
        invoice = new Invoice();
        notification = new Notification();
    }

    public void placeOrder() throws InterruptedException {
        if (inventory.checkStock()) {
            payment.processPayment();
            shipping.shipOrder();
            invoice.generateInvoice();
            notification.sendEmail();
            System.out.println("Order completed Successfully");
        }
    }
}
