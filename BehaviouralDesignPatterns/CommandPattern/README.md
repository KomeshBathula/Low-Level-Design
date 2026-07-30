# Command Design Pattern

> **"Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations."** — *Gang of Four (GoF)*

---

## 📖 Introduction

The **Command Pattern** is a behavioral design pattern that turns a request into a stand-alone object containing all information about the request (the receiver, method to call, and arguments).

This encapsulation decouples the object that invokes the command (**Invoker**) from the object that knows how to perform the action (**Receiver**). It is commonly used in remote controls, task schedulers, GUI buttons, and transaction undo engines.

---

## 🛑 Problem Statement vs. Solution

### ❌ Without Command Pattern
The invoker (e.g. Remote Control) is directly coupled to specific receiver objects and their concrete methods:
```java
// Remote control directly hardcoded to Light methods
class RemoteControl {
    private Light light;
    public void pressOn() { light.on(); }
    public void pressOff() { light.off(); }
}
```

### ✅ With Command Pattern
The invoker holds a generic `Command` interface object and executes it without knowing receiver details:
```java
// Invoker parameterised with generic Command interface
RemoteControl remote = new RemoteControl();
remote.setCommand(new LightOnCommand(light));
remote.pressButton();
```

---

## 🛠️ System Architecture & Mapping

| Component | Role | Description |
| :--- | :--- | :--- |
| **`Command`** | Command Interface | Declares execution method contract (`execute()`). |
| **`LightOnCommand`** | Concrete Command 1 | Binds action on `Light` receiver to execute `light.on()`. |
| **`LightOffCommand`** | Concrete Command 2 | Binds action on `Light` receiver to execute `light.off()`. |
| **`Light`** | Receiver | Contains real business logic (`on()`, `off()`) to fulfill requests. |
| **`RemoteControl`** | Invoker | Stores and executes commands when buttons are pressed. |
| **`Main`** | Client Entry Point | Instantiates receivers, commands, invokers and triggers execution. |

---

## 🗺️ Architectural Workflow

```mermaid
graph TD
    Client[Main Class] -->|1. Creates receiver & commands| Receiver[Light Receiver]
    Client -->|2. Configures command in invoker| Remote[RemoteControl Invoker]
    Remote -->|3. Press button triggers execute| CommandInterface["Command Interface<br/>(execute)"]

    CommandInterface <|.. OnCommand[LightOnCommand]
    CommandInterface <|.. OffCommand[LightOffCommand]

    OnCommand -->|4a. Calls light.on| Receiver
    OffCommand -->|4b. Calls light.off| Receiver

    style Client fill:#bbf,stroke:#333,stroke-width:2px
    style Remote fill:#f9f,stroke:#333,stroke-width:2px
    style CommandInterface fill:#ffd,stroke:#333,stroke-width:2px
    style OnCommand fill:#dfd,stroke:#333,stroke-width:1px
    style OffCommand fill:#dfd,stroke:#333,stroke-width:1px
    style Receiver fill:#fbb,stroke:#333,stroke-width:2px
```

---

## 🔍 Code Walkthrough

### 1. Receiver (`Light`)
Performs actual actions:
```java
class Light {
    public void on() {
        System.out.println("Light turned ON");
    }

    public void off() {
        System.out.println("Light turned OFF");
    }
}
```

### 2. Command Interface (`Command`)
Defines standard command execution signature:
```java
interface Command {
    void execute();
}
```

### 3. Concrete Commands (`LightOnCommand`, `LightOffCommand`)
Bind receiver actions to the command contract:
```java
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
```

### 4. Invoker (`RemoteControl`)
Triggers command execution on demand:
```java
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

### 5. Client Application (`Main.java`)
Configures commands and triggers remote execution:
```java
package BehaviouralDesignPatterns.CommandPattern;

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
```

---

## 💡 Key Benefits

1. **Decoupling**: Invokers are decoupled from concrete receiver objects and their execution mechanics.
2. **Open/Closed Principle (OCP)**: New commands (e.g. `FanOnCommand`) can be added without modifying existing invoker or receiver code.
3. **Supports Extensibility**: Easily extended to support macro commands, request queues, logging, and undo/redo operations.
