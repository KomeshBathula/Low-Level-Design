package StructuralDesignPatterns.FacadePattern;

public class Notification {
    
    public void sendEmail() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Email Sent");
    }
}
