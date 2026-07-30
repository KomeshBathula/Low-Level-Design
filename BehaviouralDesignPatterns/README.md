# Behavioral Design Patterns

Behavioral design patterns deal with **algorithms and the assignment of responsibilities between objects**. They describe not just patterns of objects or classes, but also the patterns of communication between them. By using composition and loose coupling, these patterns allow complex control flows to be specified cleanly without hardwiring dependencies.

---

## 📚 Pattern Index (Chronological Order)

| Design Pattern | Category | Intent | Key Benefit |
| :--- | :--- | :--- | :--- |
| **[Iterator Pattern](./IteratorPattern)** | Behavioral | Provides a way to access elements of an aggregate object sequentially without exposing its underlying representation. | Hides inner collection structures while allowing uniform iteration. |
| **[Observer Pattern](./ObserverPattern)** | Behavioral | Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically. | Decouples event publishers from subscriber listeners. |
| **[Strategy Pattern](./StrategyPattern)** | Behavioral | Defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime. | Eliminates complex `if-else`/`switch` blocks by encapsulating algorithm behavior. |
| **[Command Pattern](./CommandPattern)** | Behavioral | Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue/log requests, and support undoable operations. | Decouples the request invoker from the execution receiver. |
| **[Template Method Pattern](./TemplateMethodPattern)** | Behavioral | Defines the skeleton of an algorithm in a superclass, deferring specific steps to subclasses without modifying the overall structure. | Enforces algorithm structure while delegating customizable steps to subclasses. |
| **[State Pattern](./StatePattern)** | Behavioral | Allows an object to alter its behavior when its internal state changes, appearing to change its class. | Encapsulates state-specific behavior and transitions into standalone classes. |
| **[Chain of Responsibility](./ChainOfResponsibility)** | Behavioral | Passes requests along a chain of handlers, allowing each handler to process the request or pass it to the next handler. | Decouples senders of requests from potential receiving handlers. |
| **[Visitor Pattern](./VisitorPattern)** | Behavioral | Separates an algorithm from the object structure on which it operates by adding new operations to existing structures without modifying them. | Adds new operations across object hierarchies without altering element classes. |
| **[Mediator Pattern](./MediatorPattern)** | Behavioral | Defines an object that encapsulates how a set of objects interact, promoting loose coupling by keeping objects from referring to each other explicitly. | Centralizes multi-object communications into a single mediator object. |
| **[Memento Pattern](./MementoPattern)** | Behavioral | Captures and externalizes an object's internal state without violating encapsulation, allowing the object to be restored to this state later. | Implements undo/redo state restoration without breaking encapsulation. |

---

## 🛠️ Repository Structure

```text
BehaviouralDesignPatterns/
├── IteratorPattern/          # Sequential iteration over bookshelf collection without exposing internal storage
├── ObserverPattern/          # YouTube channel subscriber notification system (One-to-Many dependency)
├── StrategyPattern/          # Dynamic payment strategy selection (UPI, Credit Card, PayPal)
├── CommandPattern/           # Encapsulated remote control actions for turning lights ON/OFF
├── TemplateMethodPattern/    # Fixed beverage preparation algorithm with customizable steps (Tea & Coffee)
├── StatePattern/             # Order processing state transitions (Placed -> Preparing -> OutForDelivery -> Delivered)
├── ChainOfResponsibility/    # Multi-tier support request escalation (Level 1 -> Level 2 -> Manager)
├── VisitorPattern/           # External discount calculation algorithm operating across product objects
├── MediatorPattern/          # Collaborative document editing hub managing broadcast user notifications
└── MementoPattern/           # Undo capability for document editing history using state snapshots
```

---

## 🎯 Quick Decision Guide

- Need to **traverse collection elements without exposing internal structure**? 👉 Use **Iterator**
- Need **one-to-many automatic updates when state changes**? 👉 Use **Observer**
- Need to **swap algorithms dynamically at runtime**? 👉 Use **Strategy**
- Need to **decouple request invokers from execution logic or support undo/queuing**? 👉 Use **Command**
- Need to **define an invariant algorithm skeleton while letting subclasses override steps**? 👉 Use **Template Method**
- Need an object to **change behavior dynamically as its state transitions**? 👉 Use **State**
- Need a request to **pass along a chain of potential handlers until processed**? 👉 Use **Chain of Responsibility**
- Need to **add new operations to existing class hierarchies without changing their code**? 👉 Use **Visitor**
- Need to **decouple complex multi-object interactions into a central hub**? 👉 Use **Mediator**
- Need to **save and restore an object's past states without exposing internal details**? 👉 Use **Memento**
