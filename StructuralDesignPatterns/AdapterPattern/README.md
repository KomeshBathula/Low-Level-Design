# Adapter Design Pattern

> **"Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces."** — *Gang of Four (GoF)*

---

## 📖 Introduction

The **Adapter Pattern** is a structural design pattern that acts as a wrapper between two incompatible interfaces. It allows objects with incompatible interfaces to collaborate by converting the interface of one object into an interface expected by clients.

In software architecture, when integrating third-party payment gateways (like Stripe or Razorpay) or legacy libraries, their API method names and signatures (`pay(amount)` vs. `makePayment(value)`) rarely match the application's unified target interface (`processPayment(amount)`). The Adapter pattern resolves this discrepancy without altering existing third-party code or tight-coupling client code.

---

## 🛑 Problem Statement vs. Solution

### ❌ Without Adapter Pattern
Client code must handle each third-party payment gateway separately with custom logic and incompatible method calls:
```java
// Client logic directly coupled to specific third-party APIs
if (provider.equals("stripe")) {
    StripeGateway stripe = new StripeGateway();
    stripe.pay(5000); // Specific method name for Stripe
} else if (provider.equals("razorpay")) {
    RazorpayGateway razorpay = new RazorpayGateway();
    razorpay.makePayment(10000); // Specific method name for Razorpay
}
```

###  With Adapter Pattern
Client code operates strictly against a standard target interface (`PaymentProcessor`). Adapters wrap third-party SDKs and translate call signatures seamlessly:
```java
// Client works uniformly via PaymentProcessor interface
PaymentService stripeService = new PaymentService(new StripeAdapter(new StripeGateway()));
stripeService.checkout(5000);

PaymentService razorpayService = new PaymentService(new RazorpayAdapter(new RazorpayGateway()));
razorpayService.checkout(10000);
```

---

## 🛠️ System Architecture & Mapping

| Component | Role | Description |
| :--- | :--- | :--- |
| **`PaymentProcessor`** | Target Interface | Common interface declaring the contract for payment operations (`processPayment(double amount)`). |
| **`StripeGateway`** | Adaptee 1 | Incompatible 3rd-party class providing `pay(double amount)`. |
| **`RazorpayGateway`** | Adaptee 2 | Incompatible 3rd-party class providing `makePayment(double value)`. |
| **`StripeAdapter`** | Adapter 1 | Implements `PaymentProcessor` and translates calls to `StripeGateway.pay()`. |
| **`RazorpayAdapter`** | Adapter 2 | Implements `PaymentProcessor` and translates calls to `RazorpayGateway.makePayment()`. |
| **`PaymentService`** | Client Context | High-level service utilizing `PaymentProcessor` to perform checkout operations. |
| **`Main`** | Client | Configures adapters and executes payment checkouts. |

---

## 🗺️ Architectural Workflow

```mermaid
graph TD
    Client[Main Class] -->|1. Instantiates service with adapter| Service[PaymentService]
    Service -->|2. Calls checkout| Target["PaymentProcessor Interface<br/>(processPayment)"]

    Target <|.. StripeAdapter[StripeAdapter]
    Target <|.. RazorpayAdapter[RazorpayAdapter]

    StripeAdapter -->|3a. Wraps & delegates| Stripe[StripeGateway<br/>pay]
    RazorpayAdapter -->|3b. Wraps & delegates| Razorpay[RazorpayGateway<br/>makePayment]

    style Client fill:#bbf,stroke:#333,stroke-width:2px
    style Service fill:#f9f,stroke:#333,stroke-width:2px
    style Target fill:#ffd,stroke:#333,stroke-width:2px
    style StripeAdapter fill:#dfd,stroke:#333,stroke-width:1px
    style RazorpayAdapter fill:#dfd,stroke:#333,stroke-width:1px
```

---

## 🔍 Code Walkthrough

### 1. Target Interface (`PaymentProcessor.java`)
Defines the standard contract required by the client application:
```java
package StructuralDesignPatterns.AdapterPattern;

public interface PaymentProcessor {
    void processPayment(double amount);
}
```

### 2. Adaptees / Third-Party Gateways
Third-party classes with non-uniform method signatures:
- **`StripeGateway.java`**:
  ```java
  public class StripeGateway {
      public void pay(double amount) {
          System.out.println("Stripe Payment: " + amount);
      }
  }
  ```
- **`RazorpayGateway.java`**:
  ```java
  public class RazorpayGateway {
      public void makePayment(double value) {
          System.out.println("Razorpay payment: " + value);
      }
  }
  ```

### 3. Concrete Adapters
Adapters implement `PaymentProcessor` and delegate execution to their respective adaptees:
- **`StripeAdapter.java`**:
  ```java
  public class StripeAdapter implements PaymentProcessor {
      private StripeGateway stripe;

      public StripeAdapter(StripeGateway stripe) {
          this.stripe = stripe;
      }

      @Override
      public void processPayment(double amount) {
          stripe.pay(amount);
      }
  }
  ```
- **`RazorpayAdapter.java`**:
  ```java
  public class RazorpayAdapter implements PaymentProcessor {
      private RazorpayGateway razorpay;

      public RazorpayAdapter(RazorpayGateway razorpay) {
          this.razorpay = razorpay;
      }

      @Override
      public void processPayment(double amount) {
          razorpay.makePayment(amount);
      }
  }
  ```

### 4. Client Service & Entry Point
- **`PaymentService.java`**:
  ```java
  public class PaymentService {
      private PaymentProcessor paymentProcessor;

      public PaymentService(PaymentProcessor paymentProcessor) {
          this.paymentProcessor = paymentProcessor;
      }

      public void checkout(double amount) {
          paymentProcessor.processPayment(amount);
      }
  }
  ```
- **`Main.java`**:
  ```java
  public class Main {
      public static void main(String[] args) {
          PaymentService stripe = new PaymentService(new StripeAdapter(new StripeGateway()));
          stripe.checkout(5000);

          PaymentService razorpay = new PaymentService(new RazorpayAdapter(new RazorpayGateway()));
          razorpay.checkout(10000);
      }
  }
  ```

---

## 💡 Key Benefits

1. **Single Responsibility Principle (SRP)**: Separates the interface conversion and integration logic from primary business components.
2. **Open/Closed Principle (OCP)**: New payment adapters (e.g., `PayPalAdapter`) can be added without modifying existing client code or gateways.
3. **Reusability & Interoperability**: Enables legacy or incompatible third-party libraries to work seamlessly with modern application interfaces.
