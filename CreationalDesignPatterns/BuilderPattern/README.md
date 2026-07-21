# Builder Design Pattern

> **"Separate the construction of a complex object from its representation so that the same construction process can create different representations."** — *Gang of Four (GoF)*

---

## 📖 Introduction

The **Builder Pattern** is a creational design pattern designed to construct complex objects step-by-step. It is particularly useful when an object has many configurable parameters, some of which are mandatory and others optional.

Without the Builder pattern, object instantiation often results in either:
1. **Telescopic Constructors**: Constructors with long parameter lists, making the code hard to read and error-prone (e.g., passing `null` or wrong types for optional arguments).
2. **Mutable JavaBeans Pattern**: Instantiating with a no-arg constructor and using multiple setter calls, which leaves the object in an inconsistent state during instantiation and breaks immutability.

---

## 🛑 Problem Statement vs. Solution

### ❌ Telescopic Constructor Anti-Pattern
```java
// Hard to read, easy to mix up parameters of same type (e.g. ram vs ssd, or boolean flags)
Laptop laptop = new Laptop("Dell", "i7", 16, 512, true, false);
```

###  With Builder Pattern
```java
// Readable, self-documenting, thread-safe, and enforces mandatory parameters upfront
Laptop laptop = new Laptop.Builder("Dell", "i7")
        .ram(16)
        .ssd(512)
        .touchScreen(true)
        .build();
```

---

## 🛠️ System Architecture & Mapping

| Component | Role | Description |
| :--- | :--- | :--- |
| **`Laptop`** | Complex Product | Target immutable object containing mandatory (`brand`, `processor`) and optional attributes (`ram`, `ssd`, `touchScreen`, `RGBKeyboard`). |
| **`Laptop.Builder`** | Static Inner Builder | Helper class responsible for collecting state and constructing the `Laptop` instance. |
| **`Main`** | Client | Uses fluent builder method chaining to construct custom `Laptop` configurations. |

---

## 🗺️ Architectural Workflow

```mermaid
graph TD
    Client[Main Class] -->|1. Invokes Builder constructor with mandatory fields| BuilderConstructor["new Laptop.Builder('Dell', 'i7')"]
    BuilderConstructor -->|2. Fluent method chaining| ChainRam[".ram(16)"]
    ChainRam -->|3. Fluent method chaining| ChainSSD[".ssd(512)"]
    ChainSSD -->|4. Fluent method chaining| ChainTouch[".touchScreen(true)"]
    ChainTouch -->|5. Calls build()| BuildMethod["build()"]
    BuildMethod -->|6. Instantiates private constructor| LaptopObj[("Laptop Instance (Immutable)")]

    style Client fill:#bbf,stroke:#333,stroke-width:2px
    style BuilderConstructor fill:#f9f,stroke:#333,stroke-width:1px
    style BuildMethod fill:#dfd,stroke:#333,stroke-width:2px
    style LaptopObj fill:#ffd,stroke:#333,stroke-width:2px
```

---

## 🔍 Code Walkthrough

### 1. Product & Builder Structure (`Laptop.java`)
- **Private Constructor**: Prevents direct instantiation of `Laptop` outside the builder.
- **Mandatory Fields in Builder Constructor**: `brand` and `processor` must be supplied when instantiating `Laptop.Builder`.
- **Fluent Setters**: Each optional setter returns `this` to support method chaining.

```java
public class Laptop {
    private String brand;
    private String processor;
    private int ram;
    private int ssd;
    private boolean touchScreen;
    private boolean RGBKeyboard;

    // Private constructor taking Builder instance
    private Laptop(Builder builder) {
        this.brand = builder.brand;
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.ssd = builder.ssd;
        this.touchScreen = builder.touchScreen;
        this.RGBKeyboard = builder.RGBKeyboard;
    }

    public static class Builder {
        private String brand;
        private String processor;
        private int ram;
        private int ssd;
        private boolean touchScreen;
        private boolean RGBKeyboard;

        // Enforce mandatory parameters via constructor
        public Builder(String brand, String processor) {
            this.brand = brand;
            this.processor = processor;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder ssd(int ssd) {
            this.ssd = ssd;
            return this;
        }

        public Builder touchScreen(boolean touchScreen) {
            this.touchScreen = touchScreen;
            return this;
        }

        public Builder RGBKeyboard(boolean RGBKeyboard) {
            this.RGBKeyboard = RGBKeyboard;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }
}
```

### 2. Client Usage (`Main.java`)
```java
public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop.Builder("Dell", "i7")
                .ram(16)
                .ssd(512)
                .touchScreen(true)
                .build();

        System.out.println(laptop);
    }   
}
```

---

## 💡 Key Benefits

1. **Immutability**: Once constructed via `build()`, the `Laptop` object has no setter methods, making it completely immutable and thread-safe.
2. **Clear Parameter Differentiation**: Explicitly separates mandatory fields (in `Builder` constructor) from optional attributes (via fluent methods).
3. **Clean & Readable Code**: Eliminates long constructor argument lists and `null` parameter passing.
