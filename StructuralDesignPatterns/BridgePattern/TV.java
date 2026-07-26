package StructuralDesignPatterns.BridgePattern;

public class TV implements Device {

    @Override
    public void turnOn() {
        System.out.println("TV ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV OFF");
    }

    @Override
    public void volumeUp() {
        System.out.println("TV Volume +");
    }

    @Override
    public void volumeDown() {
        System.out.println("TV Volume -");
    }
}
