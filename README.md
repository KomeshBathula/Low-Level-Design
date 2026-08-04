# Low-Level Design (LLD) & Design Patterns in Java 🚀

Welcome to the **Low-Level Design (LLD)** repository! This repository is a comprehensive reference guide containing practical Java implementations of **SOLID Principles**, **Gang of Four (GoF) Design Patterns** (Creational, Structural, Behavioral), and **Multithreading & Concurrency primitives**.

---

## 📂 Repository Structure

```text
LLD/
├── 🛡️ SolidPrinciples/             # The 5 Core SOLID Principles of Object-Oriented Design
├── 🏗️ CreationalDesignPatterns/   # Patterns for object creation mechanisms
├── 🧱 StructuralDesignPatterns/   # Patterns for class and object composition
├── 🧠 BehaviouralDesignPatterns/   # Patterns for object communication & responsibilities
└── ⚡ MultithreadingAndConcurrency/ # Multi-threading models, tasks, and executors
```

---

## 🛠️ Modules & Topics Covered

### 1. 🛡️ SOLID Principles (`/SolidPrinciples`)
Software design principles for writing clean, maintainable, and scalable object-oriented code.

- **[Single Responsibility Principle (SRP)](./SolidPrinciples/SingleResponsibilityPrinciple)**: A class should have one, and only one, reason to change.
- **[Open/Closed Principle (OCP)](./SolidPrinciples/OpenClosedPrinciple)**: Software entities should be open for extension, but closed for modification.
- **[Liskov Substitution Principle (LSP)](./SolidPrinciples/LiskowSubstitutionPrinciple)**: Subtypes must be substitutable for their base types without breaking application logic.
- **[Interface Segregation Principle (ISP)](./SolidPrinciples/InterfaceSegregationPrinciple)**: Clients should not be forced to depend upon interfaces that they do not use.
- **[Dependency Inversion Principle (DIP)](./SolidPrinciples/DependencyInversionPrinciple)**: Depend upon abstractions, not concrete implementations.

---

### 2. 🏗️ Creational Design Patterns (`/CreationalDesignPatterns`)
Patterns that abstract the object instantiation process, making systems independent of how their objects are created.

- **[Abstract Factory Pattern](./CreationalDesignPatterns/AbstractFactoryPattern)**: Create families of related or dependent objects without specifying concrete classes.
- **[Builder Pattern](./CreationalDesignPatterns/BuilderPattern)**: Separate complex object construction from its representation (fluent step-by-step assembly).
- **[Factory Pattern](./CreationalDesignPatterns/FactoryPattern)**: Interface/factory class deciding which concrete class to instantiate based on conditions.
- **[Prototype Pattern](./CreationalDesignPatterns/PrototypePattern)**: Duplicate/clone existing objects without coupling code to their specific classes.
- **[Singleton Pattern](./CreationalDesignPatterns/SingletonPattern)**: Ensure a class has only one instance (covers 5 approaches: Eager, Lazy, Synchronized, Double-Checked Locking, and Bill Pugh Inner Class).

---

### 3. 🧱 Structural Design Patterns (`/StructuralDesignPatterns`)
Patterns that ease design by identifying simple ways to realize relationships between entities.

- **[Adapter Pattern](./StructuralDesignPatterns/AdapterPattern)**: Convert the interface of a class into another interface expected by clients.
- **[Bridge Pattern](./StructuralDesignPatterns/BridgePattern)**: Decouple an abstraction from its implementation so that the two can vary independently.
- **[Composite Pattern](./StructuralDesignPatterns/CompositePattern)**: Compose objects into tree structures to represent part-whole hierarchies.
- **[Decorator Pattern](./StructuralDesignPatterns/DecoratorPattern)**: Attach additional responsibilities to an object dynamically.
- **[Facade Pattern](./StructuralDesignPatterns/FacadePattern)**: Provide a unified high-level interface to a set of interfaces in a subsystem.
- **[Flyweight Pattern](./StructuralDesignPatterns/FlyweightPattern)**: Share fine-grained objects efficiently to minimize memory usage.
- **[Proxy Pattern](./StructuralDesignPatterns/ProxyPattern)**: Provide a surrogate or placeholder for another object to control access to it.

---

### 4. 🧠 Behavioral Design Patterns (`/BehaviouralDesignPatterns`)
Patterns focused on algorithms, assignment of responsibilities, and communication between objects.

- **[Chain of Responsibility](./BehaviouralDesignPatterns/ChainOfResponsibility)**: Pass requests along a chain of handlers until one processes it.
- **[Command Pattern](./BehaviouralDesignPatterns/CommandPattern)**: Encapsulate a request as an object, allowing parameterization and queueing.
- **[Iterator Pattern](./BehaviouralDesignPatterns/IteratorPattern)**: Access elements of an aggregate object sequentially without exposing underlying representations.
- **[Mediator Pattern](./BehaviouralDesignPatterns/MediatorPattern)**: Reduce chaotic dependencies between objects by restricting direct communications.
- **[Memento Pattern](./BehaviouralDesignPatterns/MementoPattern)**: Capture and restore an object's internal state without violating encapsulation.
- **[Observer Pattern](./BehaviouralDesignPatterns/ObserverPattern)**: Define a 1-to-N dependency where state changes trigger automatic notifications.
- **[State Pattern](./BehaviouralDesignPatterns/StatePattern)**: Allow an object to alter its behavior when its internal state changes.
- **[Strategy Pattern](./BehaviouralDesignPatterns/StrategyPattern)**: Define a family of algorithms, encapsulate each one, and make them interchangeable.
- **[Template Method Pattern](./BehaviouralDesignPatterns/TemplateMethodPattern)**: Define the skeleton of an algorithm in an operation, deferring steps to subclasses.
- **[Visitor Pattern](./BehaviouralDesignPatterns/VisitorPattern)**: Separate an algorithm from an object structure on which it operates.

---

### 5. ⚡ Multithreading & Concurrency (`/MultithreadingAndConcurrency`)
Core Java concurrency concepts and thread execution models.

- **[UsingThread](./MultithreadingAndConcurrency/UsingThread)**: Basic thread creation by extending `java.lang.Thread`.
- **[UsingRunnable](./MultithreadingAndConcurrency/UsingRunnable)**: Task definition by implementing the `Runnable` interface.
- **[UsingCallable](./MultithreadingAndConcurrency/UsingCallable)**: Returning results and handling checked exceptions using `Callable` and `Future`.
- **[UsingExecutorFramework](./MultithreadingAndConcurrency/UsingExecutorFramework)**: Managing thread pools and asynchronous task execution via `ExecutorService`.

---

## 💻 How to Compile and Run

You can run any module using standard Java CLI commands from the root directory:

```bash
# Example: Compiling and running the Creational Factory Pattern
javac CreationalDesignPatterns/FactoryPattern/*.java
java CreationalDesignPatterns.FactoryPattern.Main

# Example: Compiling and running the Builder Pattern
javac CreationalDesignPatterns/BuilderPattern/*.java
java CreationalDesignPatterns.BuilderPattern.Main
```

---

## 🌟 Key Highlights

- **Decoupled Architecture**: Clean contracts using Java Interfaces and Abstract Classes.
- **Detailed READMEs**: Every design pattern folder includes an individual `README.md` complete with problem statements, architectural diagrams, code walkthroughs, and key benefits.
- **Production Best Practices**: Thread-safety considerations, immutability, and loose coupling applied throughout the code examples.
