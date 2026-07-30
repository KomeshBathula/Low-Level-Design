# Iterator Design Pattern

> **"Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation."** — *Gang of Four (GoF)*

---

## 📖 Introduction

The **Iterator Pattern** is a behavioral design pattern that allows sequential traversal over elements of a collection without exposing its underlying internal structure (such as an array, list, tree, or graph).

By decoupling the traversal algorithm from the aggregate collection object, clients can iterate over different types of collections in a uniform manner using a standardized interface.

---

## 🛑 Problem Statement vs. Solution

### ❌ Without Iterator Pattern
Client code must be aware of the internal storage implementation (e.g. array vs linked list) and write custom loop logic tied to specific data structures:
```java
// Client exposed to internal Book[] array storage details
Book[] books = shelf.getBooks();
for (int i = 0; i < books.length; i++) {
    System.out.println(books[i].getName());
}
```

### ✅ With Iterator Pattern
Client code iterates over elements uniformly through an `Iterator` abstraction (`hasNext()` and `next()`), unaware of internal data representation:
```java
// Client iterates uniformly without knowing internal storage mechanism
Iterator iterator = shelf.createIterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next().getName());
}
```

---

## 🛠️ System Architecture & Mapping

| Component | Role | Description |
| :--- | :--- | :--- |
| **`Iterator`** | Iterator Interface | Defines the contract for element traversal (`hasNext()`, `next()`). |
| **`BookIterator`** | Concrete Iterator | Implements `Iterator` to track position and traverse the `Book[]` array. |
| **`Book`** | Element Domain Model | Represents the individual item (`Book`) stored in the aggregate collection. |
| **`BookShelf`** | Aggregate Collection | Contains the collection of books and provides factory method `createIterator()`. |
| **`Main`** | Client Entry Point | Creates `BookShelf`, obtains `Iterator`, and traverses the elements sequentially. |

---

## 🗺️ Architectural Workflow

```mermaid
graph TD
    Client[Main Class] -->|1. Requests Iterator| Aggregate[BookShelf]
    Aggregate -->|2. Instantiates| ConcreteIterator[BookIterator]
    Client -->|3. Traverses via hasNext & next| IteratorInterface["Iterator Interface<br/>(hasNext, next)"]
    ConcreteIterator ..|> IteratorInterface
    ConcreteIterator -->|4. Accesses items| Element[Book Objects]

    style Client fill:#bbf,stroke:#333,stroke-width:2px
    style Aggregate fill:#f9f,stroke:#333,stroke-width:2px
    style IteratorInterface fill:#ffd,stroke:#333,stroke-width:2px
    style ConcreteIterator fill:#dfd,stroke:#333,stroke-width:1px
```

---

## 🔍 Code Walkthrough

### 1. Iterator Interface (`Iterator.java`)
Declares standard traversal operations:
```java
package BehaviouralDesignPatterns.IteratorPattern;

public interface Iterator {
    boolean hasNext();
    Book next();
}
```

### 2. Element Model (`Book.java`)
Represents individual collection items:
```java
package BehaviouralDesignPatterns.IteratorPattern;

public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

### 3. Concrete Iterator (`BookIterator.java`)
Implements iteration logic over an array of `Book` objects:
```java
package BehaviouralDesignPatterns.IteratorPattern;

public class BookIterator implements Iterator {
    private Book[] books;
    private int index = 0;

    public BookIterator(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.length;
    }

    @Override
    public Book next() {
        return books[index++];
    }
}
```

### 4. Aggregate Collection (`BookShelf.java`)
Provides access to its iterator instance:
```java
package BehaviouralDesignPatterns.IteratorPattern;

public class BookShelf {
    private Book[] books;

    public BookShelf(Book[] books) {
        this.books = books;
    }

    public Iterator createIterator() {
        return new BookIterator(books);
    }
}
```

### 5. Client Application (`Main.java`)
Traverses collection elements uniformly:
```java
package BehaviouralDesignPatterns.IteratorPattern;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Java"),
                new Book("Spring"),
                new Book("Docker"),
                new Book("Kubernetes")
        };

        BookShelf shelf = new BookShelf(books);
        Iterator iterator = shelf.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
```

---

## 💡 Key Benefits

1. **Single Responsibility Principle (SRP)**: Separates traversal algorithms into dedicated iterator classes, keeping collection classes focused on data storage.
2. **Open/Closed Principle (OCP)**: Enables adding new types of collections and iterators without modifying existing client code.
3. **Encapsulation & Uniformity**: Hides internal collection data structures while providing a consistent interface across different data structures.
