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
