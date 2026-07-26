# Composite Design Pattern

> **"Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly."** — *Gang of Four (GoF)*

---

## 📖 Introduction

The **Composite Pattern** is a structural design pattern used to compose objects into tree structures that represent part-whole hierarchies. It enables clients to treat individual leaf objects and composite containers of objects uniformly through a common component interface.

In file systems, graphic vector editors, or organizational charts, elements naturally form a tree hierarchy. For instance, a directory (Folder) can contain individual items (Files) as well as subdirectories (Folders). The Composite pattern allows recursive operations—such as calculating total size or displaying details—to execute uniformly regardless of whether the node target is a single file or a complex nested directory structure.

---

## 🛑 Problem Statement vs. Solution

### ❌ Without Composite Pattern (Type Checks & Branching)
Client code must distinguish between leaf elements (`File`) and container elements (`Folder`), leading to complex conditional branching:
```java
// Client must manually differentiate leaf vs container types
if (element instanceof File) {
    totalSize += ((File) element).getSize();
} else if (element instanceof Folder) {
    // Requires recursive traversal over folder contents
    totalSize += calculateFolderSize((Folder) element);
}
```

###  With Composite Pattern
Client code interacts uniformly via the `FileSystemComponent` interface without caring whether an object is a leaf or a composite container:
```java
// Client treats files and nested folders uniformly
FileSystemComponent documents = new Folder("Documents");
documents.showDetails();
System.out.println("Total Size = " + documents.getSize() + " MB");
```

---

## 🛠️ System Architecture & Mapping

| Component | Role | Description |
| :--- | :--- | :--- |
| **`FileSystemComponent`** | Component Interface | Declares the common interface for all elements in the tree (`showDetails()`, `getSize()`). |
| **`File`** | Leaf | Represents leaf node objects with no children (`name`, `size`). |
| **`Folder`** | Composite | Container node that holds a collection of `FileSystemComponent` children (`List<FileSystemComponent>`). |
| **`Main`** | Client | Assembles nested tree structures and executes operations uniformly on composite roots. |

---

## 🗺️ Architectural Workflow

```mermaid
graph TD
    Client[Main Class] -->|Executes showDetails / getSize| Root["Documents (Folder)"]

    Root -->|Contains| Child1["Resume.pdf (File)"]
    Root -->|Contains| Child2["Notes.txt (File)"]
    Root -->|Contains| Child3["Images (Folder)"]

    Child3 -->|Contains| NestedChild["Photo.jpg (File)"]

    Root ..|> Component["<<interface>><br/>FileSystemComponent"]
    Child1 ..|> Component
    Child2 ..|> Component
    Child3 ..|> Component
    NestedChild ..|> Component

    style Client fill:#bbf,stroke:#333,stroke-width:2px
    style Component fill:#ffd,stroke:#333,stroke-width:2px
    style Root fill:#f9f,stroke:#333,stroke-width:1px
    style Child3 fill:#f9f,stroke:#333,stroke-width:1px
    style Child1 fill:#dfd,stroke:#333,stroke-width:1px
    style Child2 fill:#dfd,stroke:#333,stroke-width:1px
    style NestedChild fill:#dfd,stroke:#333,stroke-width:1px
```

---

## 🔍 Code Walkthrough

### 1. Component Interface (`FileSystemComponent.java`)
Defines common operations shared by leaves and composites:
```java
package StructuralDesignPatterns.CompositePattern;

public interface FileSystemComponent {

    void showDetails();

    int getSize();
}
```

### 2. Leaf Component (`File.java`)
Represents terminal objects in the tree hierarchy with concrete values:
```java
package StructuralDesignPatterns.CompositePattern;

public class File implements FileSystemComponent {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " (" + size + " MB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}
```

### 3. Composite Component (`Folder.java`)
Manages child components and delegates work recursively to them:
```java
package StructuralDesignPatterns.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder : " + name);
        for (FileSystemComponent child : children) {
            child.showDetails();
        }
    }

    @Override
    public int getSize() {
        int total = 0;
        for (FileSystemComponent child : children) {
            total += child.getSize();
        }
        return total;
    }
}
```

### 4. Client Usage (`Main.java`)
Builds a nested file system tree and operates on composite roots:
```java
package StructuralDesignPatterns.CompositePattern;

public class Main {

    public static void main(String[] args) {

        File file1 = new File("Resume.pdf", 5);
        File file2 = new File("Notes.txt", 2);
        File file3 = new File("Photo.jpg", 3);

        Folder images = new Folder("Images");
        images.add(file3);

        Folder documents = new Folder("Documents");
        documents.add(file1);
        documents.add(file2);
        documents.add(images);

        documents.showDetails();

        System.out.println();
        System.out.println("Total Size = " + documents.getSize() + " MB");
    }
}
```

---

## 💡 Key Benefits

1. **Uniform Treatment of Objects**: Clients interact with complex tree structures and individual leaf nodes using the exact same interface methods.
2. **Open/Closed Principle (OCP)**: New leaf or composite types (e.g., `Shortcut`, `Symlink`) can be added without breaking client code or existing components.
3. **Simplified Client Code**: Eliminates tedious type-checking, casting, and conditional logic when traversing hierarchical tree structures.
