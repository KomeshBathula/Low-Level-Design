package MultithreadingAndConcurrency.UsingRunnable;

class SMSThread implements Runnable {
    public void run() {
        System.out.println("Sending SMS...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        System.out.println("SMS Sent");
    }
}

class EmailThread implements Runnable {
    public void run() {
        System.out.println("Sending Email...");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {}

        System.out.println("Email Sent");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread sms = new Thread(new SMSThread());
        System.out.println("Simulation started");
        sms.start();

        Thread email = new Thread(new EmailThread());
        email.start();


        try {
            sms.join();
            email.join();
            System.out.println("All simulations completed!");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
