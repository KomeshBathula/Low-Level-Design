package BehaviouralDesignPatterns.CommandPattern;

// ========= Receiver classes ===========
// Light with basic on/off methods
class Light {
    public void on() {
        System.out.println("Light turned ON");
    }

    public void off() {
        System.out.println("Light turned OFF");
    }
}


// ========= Command interface ===========
//    defines the command structure
interface Command {

    void execute();
}

// Concrete commands for Light ON and OFF
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

}

// ========== Remote control class (Invoker) ==========
class RemoteControl {
    private Command command;

    // Assign command to slot
    public void setCommand(Command command) {
        this.command = command;
    }

    // Press the button to execute the command
    public void pressButton() {

        command.execute();
    }

}

// ========= Client code ===========
public class Main {

    public static void main(String[] args) {

        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
