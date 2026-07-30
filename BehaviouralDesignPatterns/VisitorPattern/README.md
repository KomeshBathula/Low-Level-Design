# Visitor Design Pattern

> **"Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates."** — *Gang of Four (GoF)*

---

## 📖 Introduction

The **Visitor Pattern** is a behavioral design pattern that allows separating algorithms and operations from the object structures on which they operate. Using **double dispatch**, elements accept a visitor object, which then calls a visit method corresponding to the specific element type.

This pattern is widely used in document compilers/AST processing, reporting engines, exporting data across diverse domain models, and dynamic pricing/discount calculators.

---

## 🛑 Problem Statement vs. Solution

### ❌ Without Visitor Pattern
Adding new operational features (e.g. tax calculation, discount calculations, serialization) requires modifying every element class:
```java
// Modifying element classes directly to add new algorithms
class Laptop {
    public double getDiscount() { return price * 0.10; }
}
class Mobile {
    public double getDiscount() { return price * 0.05; }
}
```

### ✅ With Visitor Pattern
New operations are encapsulated in separate visitor classes. Element classes remain unchanged and simply `accept(visitor)`:
```java
// New algorithms added via visitors without modifying element classes
Visitor discountVisitor = new DiscountVisitor();
laptop.accept(discountVisitor);
mobile.accept(discountVisitor);
```

---

## 🛠️ System Architecture & Mapping

| Component | Role | Description |
| :--- | :--- | :--- |
| **`Product`** | Element Interface | Declares `accept(Visitor visitor)` entry point for double dispatch. |
| **`Laptop`** | Concrete Element 1 | Implements `accept()` and exposes `getPrice()`. |
| **`Mobile`** | Concrete Element 2 | Implements `accept()` and exposes `getPrice()`. |
| **`Headphones`** | Concrete Element 3 | Implements `accept()` and exposes `getPrice()`. |
| **`Visitor`** | Visitor Interface | Declares overloaded `visit()` methods for each concrete element type. |
| **`DiscountVisitor`** | Concrete Visitor | Implements element-specific discount calculation operations. |
| **`Main`** | Client Entry Point | Instantiates products, visitor, and executes double dispatch operations. |

---

## 🗺️ Architectural Workflow

```mermaid
graph TD
    Client[Main Class] -->|1. Creates elements & visitor| Visitor[DiscountVisitor]
    Client -->|2. Calls accept| Product["Product Interface<br/>(accept)"]

    Product <|.. Laptop[Laptop Element]
    Product <|.. Mobile[Mobile Element]
    Product <|.. Headphones[Headphones Element]

    Laptop -->|3a. Double dispatch: visitor.visit(this)| Visitor
    Mobile -->|3b. Double dispatch: visitor.visit(this)| Visitor
    Headphones -->|3c. Double dispatch: visitor.visit(this)| Visitor

    style Client fill:#bbf,stroke:#333,stroke-width:2px
    style Product fill:#ffd,stroke:#333,stroke-width:2px
    style Visitor fill:#f9f,stroke:#333,stroke-width:2px
    style Laptop fill:#dfd,stroke:#333,stroke-width:1px
    style Mobile fill:#dfd,stroke:#333,stroke-width:1px
    style Headphones fill:#dfd,stroke:#333,stroke-width:1px
```

---

## 🔍 Code Walkthrough

### 1. Element Interface (`Product`)
Defines the `accept` method signature:
```java
interface Product {
    void accept(Visitor visitor);
}
```

### 2. Visitor Interface (`Visitor`)
Defines overloaded `visit` methods for each element type:
```java
interface Visitor {
    void visit(Laptop laptop);
    void visit(Mobile mobile);
    void visit(Headphones headphones);
}
```

### 3. Concrete Elements (`Laptop`, `Mobile`, `Headphones`)
Implement `accept()` to perform double dispatch:
```java
class Laptop implements Product {
    private double price;

    public Laptop(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Mobile implements Product {
    private double price;

    public Mobile(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Headphones implements Product {
    private double price;

    public Headphones(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

### 4. Concrete Visitor (`DiscountVisitor`)
Contains element-specific algorithm logic:
```java
class DiscountVisitor implements Visitor {
    @Override
    public void visit(Laptop laptop) {
        double discount = laptop.getPrice() * 0.10;
        System.out.println("Laptop Discount : $" + discount);
    }

    @Override
    public void visit(Mobile mobile) {
        double discount = mobile.getPrice() * 0.05;
        System.out.println("Mobile Discount : $" + discount);
    }

    @Override
    public void visit(Headphones headphones) {
        double discount = headphones.getPrice() * 0.20;
        System.out.println("Headphones Discount : $" + discount);
    }
}
```

### 5. Client Application (`Main.java`)
Executes visitor operations across products:
```java
package BehaviouralDesignPatterns.VisitorPattern;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Laptop(1000);
        Product mobile = new Mobile(500);
        Product headphones = new Headphones(200);

        Visitor discountVisitor = new DiscountVisitor();

        laptop.accept(discountVisitor);
        mobile.accept(discountVisitor);
        headphones.accept(discountVisitor);
    }
}
```

---

## 💡 Key Benefits

1. **Open/Closed Principle (OCP)**: New operations (e.g. `TaxVisitor`, `ExportVisitor`) can be added without modifying existing element classes.
2. **Single Responsibility Principle (SRP)**: Groups related algorithms into visitor classes rather than cluttering element domain classes.
3. **Double Dispatch Mechanism**: Selects algorithm execution at runtime based on both visitor type and element concrete type.
