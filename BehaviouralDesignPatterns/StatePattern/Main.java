package BehaviouralDesignPatterns.StatePattern;

class Order {

    private OrderState state;

    public Order() {
        state = new PlacedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }
}

interface OrderState {

    void next(Order order);

}

class PlacedState implements OrderState {

    @Override
    public void next(Order order) {

        System.out.println("Food is being prepared");

        order.setState(new PreparingState());
    }
}

class PreparingState implements OrderState {

    @Override
    public void next(Order order) {

        System.out.println("Delivery partner assigned");

        order.setState(new OutForDeliveryState());
    }
}

class OutForDeliveryState implements OrderState {

    @Override
    public void next(Order order) {

        System.out.println("Order Delivered");

        order.setState(new DeliveredState());
    }
}

class DeliveredState implements OrderState {

    @Override
    public void next(Order order) {

        System.out.println("Order already delivered");
    }
}

public class Main {

    public static void main(String[] args) {

        Order order = new Order();

        order.nextState();

        order.nextState();

        order.nextState();

        order.nextState();

        order.nextState();
    }
}