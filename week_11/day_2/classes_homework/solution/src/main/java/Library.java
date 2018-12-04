import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private String name;
    private int capacity;
    private ArrayList<Book> books;

    public Library(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.books = new ArrayList<>();
    }

    public int getBookCount(){
        return this.books.size();
    }

    public void addBook(Book book){
        if (!isFull()){
            this.books.add(book);
        }
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }

    public void buyFromPublisher(Publisher publisher){
        if (!isFull()){
            Book book = publisher.getBook();
            addBook(book);
        }
    }

    public boolean isFull(){
        return books.size() >= this.capacity;
    }

    public Book getBook(String title) {
        Book foundBook = null;
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                foundBook = this.books.remove(this.books.indexOf(book));
                break;
            }
        }
        return foundBook;
    }

}
