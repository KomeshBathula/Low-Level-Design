package MultithreadingAndConcurrency.UsingCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ETAThread implements Callable<Integer> {
    public Integer call() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { }
        
        System.out.println("Calculating the Time to Arrive ...");
        return 15;
    }
}

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
    public static void main(String[] args) throws Exception {
        Thread sms = new Thread(new SMSThread());
        System.out.println("Simulation started");
        sms.start();

        Thread email = new Thread(new EmailThread());
        email.start();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new ETAThread());

        Integer eta = future.get();
        System.out.println(eta);
        executor.shutdown();


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