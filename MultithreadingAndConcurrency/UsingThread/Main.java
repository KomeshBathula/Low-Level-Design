package MultithreadingAndConcurrency.UsingThread;

class SMSThread extends Thread {
    public void run() {
        System.out.println("Sending SMS...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        System.out.println("SMS Sent");
    }
}

class EmailThread extends Thread {
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
        SMSThread sms = new SMSThread();
        System.out.println("Simulation started");
        sms.start();

        EmailThread email = new EmailThread();
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
