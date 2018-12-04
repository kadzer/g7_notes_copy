import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;
    Library library;
    Book book;

    @Before
    public void before() {
        borrower = new Borrower("Adrian Mole");
        library = new Library("Mitchell", 5);
        book = new Book("War and Peace", "Leo Tolstoy", "Crime");
    }

    @Test
    public void hasName(){
        assertEquals("Adrian Mole", borrower.getName());
    }

    @Test
    public void canGetBookCount(){
        assertEquals(0, borrower.bookCount());
    }

    @Test
    public void canAddBook(){
        borrower.addBook(book);
        assertEquals(1, borrower.bookCount());
    }

    @Test
    public void canBorrowFromLibrary(){
        library.addBook(book);
        borrower.addBookFromLibrary(library, "War and Peace");
        assertEquals(1, borrower.bookCount());
    }

    @Test
    public void cantAddBookIfNotInLibrary(){
        library.addBook(book);
        borrower.addBookFromLibrary(library, "Hitchhikers guide to library");
        assertEquals(0, borrower.bookCount());
    }
}
