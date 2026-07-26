# Structural Design Patterns

Structural design patterns explain how to assemble **objects and classes into larger structures** while keeping these structures flexible and efficient. They focus on simplifying structure by identifying relationships between components, using composition and interfaces to decouple responsibilities.

---

## 📚 Pattern Index

| Design Pattern | Category | Intent | Key Benefit |
| :--- | :--- | :--- | :--- |
| **[Adapter Pattern](./AdapterPattern)** | Structural | Converts the interface of a class into another interface clients expect, letting incompatible interfaces work together. | Integrates third-party/legacy payment gateways (Stripe, Razorpay) without modifying existing code. |
| **[Composite Pattern](./CompositePattern)** | Structural | Composes objects into tree structures to represent part-whole hierarchies, treating individual objects and compositions uniformly. | Uniformly calculates sizes and displays details across nested file & folder hierarchies. |
| **[Decorator Pattern](./DecoratorPattern)** | Structural | Attaches additional responsibilities to an object dynamically at runtime without modifying its class. | Dynamically layers features (e.g., Cheese, Mushroom toppings on Pizza) avoiding class explosion. |
| **[Facade Pattern](./FacadePattern)** | Structural | Provides a unified, higher-level interface to a set of interfaces in a complex subsystem. | Simplifies complex e-commerce order processing workflows behind a single `placeOrder()` entry point. |

---

## 🛠️ Repository Structure

```text
StructuralDesignPatterns/
├── AdapterPattern/     # Unified payment processing adapting Stripe & Razorpay SDKs
├── CompositePattern/   # Hierarchical file system (File & Folder tree nodes)
├── DecoratorPattern/   # Dynamic pizza topping customization via object composition
└── FacadePattern/      # E-commerce fulfillment facade orchestrating inventory, payment, shipping, invoice & notification
```

---

## 🎯 Quick Decision Guide

- Need to **integrate incompatible interfaces or legacy libraries**? 👉 Use **Adapter**
- Need to **represent part-whole tree hierarchies** and treat leaves and containers uniformly? 👉 Use **Composite**
- Need to **dynamically add features/responsibilities at runtime** without subclass explosion? 👉 Use **Decorator**
- Need a **simplified single entry point for a complex multi-class subsystem**? 👉 Use **Facade**
