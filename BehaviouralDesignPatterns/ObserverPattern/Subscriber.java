package BehaviouralDesignPatterns.ObserverPattern;

public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String video) {

        System.out.println(name +
                " received notification: " + video);
    }
}
