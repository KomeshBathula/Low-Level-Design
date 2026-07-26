package StructuralDesignPatterns.BridgePattern;

public class Radio implements Device {

    @Override
    public void turnOn() {
        System.out.println("Radio ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio OFF");
    }

    @Override
    public void volumeUp() {
        System.out.println("Radio Volume +");
    }

    @Override
    public void volumeDown() {
        System.out.println("Radio Volume -");
    }
}
