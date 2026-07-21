# Creational Design Patterns

Creational design patterns focus on the mechanisms of **object creation**. They abstract the instantiation process, making a system independent of how its objects are created, composed, and represented. By encapsulating knowledge about which concrete classes the system uses, these patterns enhance code flexibility, reusability, and maintainability.

---

## 📚 Pattern Index

| Design Pattern | Category | Intent | Key Benefit |
| :--- | :--- | :--- | :--- |
| **[Abstract Factory Pattern](./AbstractFactoryPattern)** | Creational | Provides an interface for creating families of related or dependent objects without specifying their concrete classes. | Enforces consistency among related objects (e.g., Mac vs Windows UI themes). |
| **[Builder Pattern](./BuilderPattern)** | Creational | Separates the construction of a complex object from its representation, allowing the same construction process to create different configurations. | Eliminates telescopic constructors and provides fluent step-by-step object assembly. |
| **[Factory Pattern](./FactoryPattern)** | Creational | Defines an interface/class for creating objects while letting the factory logic decide which concrete class to instantiate. | Decouples object instantiation logic from the client code. |
| **[Prototype Pattern](./PrototypePattern)** | Creational | Specifies the types of objects to create using a prototypical instance, creating new objects by cloning this prototype. | Avoids expensive object creation costs by duplicating existing initialized instances. |
| **[Singleton Pattern](./SingletonPattern)** | Creational | Ensures a class has only one instance throughout the application lifecycle and provides a global point of access to it. | Controls shared resource access (e.g., Database connections, Logging services). |

---

## 🛠️ Repository Structure

```text
CreationalDesignPatterns/
├── AbstractFactoryPattern/     # Cross-platform UI toolkit implementation (Mac vs Windows)
├── BuilderPattern/             # Fluent Laptop builder handling mandatory & optional attributes
├── FactoryPattern/             # Payment processing system (Credit Card, UPI, PayPal)
├── PrototypePattern/           # Object cloning via custom generic Prototype interface
└── SingletonPattern/           # 5 distinct approaches (Eager, Lazy, Synchronized, Double-Checked, Bill Pugh)
```

---

## 🎯 Quick Decision Guide

- Need **families of matching products**? 👉 Use **Abstract Factory**
- Need to construct **complex objects step-by-step** with optional parameters? 👉 Use **Builder**
- Need to instantiate **different subclasses based on input runtime conditions**? 👉 Use **Factory**
- Need to create **copies of existing expensive objects**? 👉 Use **Prototype**
- Need **exactly one instance** across the entire application? 👉 Use **Singleton**
