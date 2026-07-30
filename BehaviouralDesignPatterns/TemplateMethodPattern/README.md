# Template Method Design Pattern

> **"Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure."** — *Gang of Four (GoF)*

---

## 📖 Introduction

The **Template Method Pattern** is a behavioral design pattern that defines the high-level skeleton of an algorithm in a base superclass while allowing subclasses to override specific steps without modifying the overall control flow.

The template method itself is marked `final` so subclasses cannot change the step sequence, enforcing architectural consistency across invariant steps while delegating variable steps.

---

## 🛑 Problem Statement vs. Solution

### ❌ Without Template Method Pattern
Subclasses duplicate invariant algorithm logic across multiple implementations:
```java
// Duplicated boiling water and pouring logic across Tea and Coffee classes
class Tea {
    public void prepare() {
        System.out.println("Boiling Water");
        System.out.println("Adding Tea Leaves");
        System.out.println("Pouring into Cup");
        System.out.println("Adding Sugar");
    }
}
```

### ✅ With Template Method Pattern
Superclass encapsulates invariant sequence in a `final makeDrink()` method; subclasses only customize specific steps:
```java
// Template method enforces structure invariant steps
Beverage tea = new Tea();
tea.makeDrink(); // Executes boilWater -> addIngredients -> pourIntoCup -> addExtras

Beverage coffee = new Coffee();
coffee.makeDrink();
```

---

## 🛠️ System Architecture & Mapping

| Component | Role | Description |
| :--- | :--- | :--- |
| **`Beverage`** | Abstract Class | Declares `final makeDrink()` template method and abstract step hooks (`addIngredients()`, `addExtras()`). |
| **`Tea`** | Concrete Class 1 | Overrides `addIngredients()` (Tea leaves) and `addExtras()` (Sugar). |
| **`Coffee`** | Concrete Class 2 | Overrides `addIngredients()` (Coffee powder) and `addExtras()` (Milk). |
| **`Main`** | Client Entry Point | Instantiates beverage concrete objects and executes `makeDrink()`. |

---

## 🗺️ Architectural Workflow

```mermaid
graph TD
    Client[Main Class] -->|1. Calls template method makeDrink| AbstractClass["Beverage Abstract Class<br/>(makeDrink final)"]

    AbstractClass --> Step1["1. boilWater() (Concrete invariant)"]
    Step1 --> Step2["2. addIngredients() (Abstract hook)"]
    Step2 --> Step3["3. pourIntoCup() (Concrete invariant)"]
    Step3 --> Step4["4. addExtras() (Abstract hook)"]

    AbstractClass <|-- TeaSubclass[Tea Subclass]
    AbstractClass <|-- CoffeeSubclass[Coffee Subclass]

    Step2 .->|Overridden by| TeaSubclass
    Step4 .->|Overridden by| TeaSubclass
    Step2 .->|Overridden by| CoffeeSubclass
    Step4 .->|Overridden by| CoffeeSubclass

    style Client fill:#bbf,stroke:#333,stroke-width:2px
    style AbstractClass fill:#f9f,stroke:#333,stroke-width:2px
    style TeaSubclass fill:#dfd,stroke:#333,stroke-width:1px
    style CoffeeSubclass fill:#dfd,stroke:#333,stroke-width:1px
```

---

## 🔍 Code Walkthrough

### 1. Abstract Template Class (`Beverage`)
Defines the fixed algorithm skeleton:
```java
abstract class Beverage {
    // Template method declared final to prevent overriding structure
    public final void makeDrink() {
        boilWater();
        addIngredients();
        pourIntoCup();
        addExtras();
    }

    public void boilWater() {
        System.out.println("Boiling Water");
    }

    public void pourIntoCup() {
        System.out.println("Pouring into Cup");
    }

    abstract void addIngredients();
    abstract void addExtras();
}
```

### 2. Concrete Implementation 1 (`Tea`)
Overrides beverage preparation steps:
```java
class Tea extends Beverage {
    @Override
    void addIngredients() {
        System.out.println("Adding Tea Leaves");
    }

    @Override
    void addExtras() {
        System.out.println("Adding Sugar");
    }
}
```

### 3. Concrete Implementation 2 (`Coffee`)
Overrides beverage preparation steps:
```java
class Coffee extends Beverage {
    @Override
    void addIngredients() {
        System.out.println("Adding Coffee Powder");
    }

    @Override
    void addExtras() {
        System.out.println("Adding Milk");
    }
}
```

### 4. Client Application (`Main.java`)
Executes the template method across subclasses:
```java
package BehaviouralDesignPatterns.TemplateMethodPattern;

public class Main {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.makeDrink();

        System.out.println();

        Beverage coffee = new Coffee();
        coffee.makeDrink();
    }
}
```

---

## 💡 Key Benefits

1. **Code Reuse**: Invariant steps (`boilWater()`, `pourIntoCup()`) are implemented once in the superclass.
2. **Inversion of Control**: Superclass calls subclass operations, adhering to the *Hollywood Principle* ("Don't call us, we'll call you").
3. **Guaranteed Sequence**: Enforces standard execution workflow across all subclasses via `final` template methods.
