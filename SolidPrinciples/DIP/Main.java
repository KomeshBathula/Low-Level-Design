package SolidPrinciples.DIP;

public class Main {

    public static void main(String[] args) {

        PaymentService service = new PaymentService(new CreditCardPayment());

        service.checkout(5000);

        service = new PaymentService(new UpiPayment());

        service.checkout(3000);
    }
}