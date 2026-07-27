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
