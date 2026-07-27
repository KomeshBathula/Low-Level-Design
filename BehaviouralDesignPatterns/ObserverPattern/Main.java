package BehaviouralDesignPatterns.ObserverPattern;

public class Main {

    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        Subscriber alice = new Subscriber("Alice");
        Subscriber bob = new Subscriber("Bob");
        Subscriber charlie = new Subscriber("Charlie");

        channel.addObserver(alice);
        channel.addObserver(bob);
        channel.addObserver(charlie);

        channel.uploadVideo("Observer Pattern Explained");
    }
}