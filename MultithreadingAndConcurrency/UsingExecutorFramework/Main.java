package MultithreadingAndConcurrency.UsingExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void sendEmail(String recipient) {

        executor.execute(() -> {
            System.out.println("Sending email to "+recipient+" on "+ Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.println("Email sent to "+recipient);
        });
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 25; i++) {
            sendEmail("user"+i+"@gmail.com");
        }
        executor.shutdown();
    }
}
