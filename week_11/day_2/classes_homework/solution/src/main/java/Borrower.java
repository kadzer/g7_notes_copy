import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> books;

    public Borrower(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int bookCount(){
        return this.books.size();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addBookFromLibrary(Library library, String title){
        Book book = library.getBook(title);
        if (book != null) {
            addBook(book);
        }
    }
}
