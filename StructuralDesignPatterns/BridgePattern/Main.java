package StructuralDesignPatterns.BridgePattern;

public class Main {

    public static void main(String[] args) {

        Device tv = new TV();

        Remote remote = new BasicRemote(tv);

        remote.powerOn();
        remote.volumeUp();

        System.out.println();

        Device radio = new Radio();

        Remote remote2 = new AdvancedRemote(radio);

        remote2.powerOn();
        remote2.volumeDown();

        ((AdvancedRemote) remote2).mute();
    }
}
