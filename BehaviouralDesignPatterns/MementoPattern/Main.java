package BehaviouralDesignPatterns.MementoPattern;


import java.util.Stack;


class DocumentMemento {

    private final String content;

    public DocumentMemento(String content) {
        this.content = content;
    }

    public String getSavedContent() {
        return content;
    }
}

class Document {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public DocumentMemento save() {
        return new DocumentMemento(content);
    }

    public void restore(DocumentMemento memento) {
        content = memento.getSavedContent();
    }
}


class History {

    private Stack<DocumentMemento> history = new Stack<>();

    public void save(DocumentMemento memento) {
        history.push(memento);
    }

    public DocumentMemento undo() {
        return history.pop();
    }
}


public class Main {

    public static void main(String[] args) {

        Document document = new Document();
        History history = new History();

        document.setContent("Hello");
        history.save(document.save());

        document.setContent("Hello World");
        history.save(document.save());

        document.setContent("Oops! Everything Deleted");

        System.out.println(document.getContent());

        document.restore(history.undo());

        System.out.println(document.getContent());

        document.restore(history.undo());

        System.out.println(document.getContent());
    }
}
