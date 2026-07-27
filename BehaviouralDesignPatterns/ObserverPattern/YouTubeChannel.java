package BehaviouralDesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private String latestVideo;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(latestVideo);
        }
    }

    public void uploadVideo(String video) {

        this.latestVideo = video;

        System.out.println("\nNew Video Uploaded : " + video);

        notifyObservers();
    }
}
