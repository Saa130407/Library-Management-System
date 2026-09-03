import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        if (findBookById(book.getId()) != null) {
            return false;
        }

        books.add(book);
        return true;
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public boolean deleteBook(int id) {
        Book book = findBookById(id);

        if (book == null) {
            return false;
        }

        books.remove(book);
        return true;
    }

    public boolean issueBook(int id) {
        Book book = findBookById(id);

        if (book == null || book.isIssued()) {
            return false;
        }

        book.issueBook();
        return true;
    }

    public boolean returnBook(int id) {
        Book book = findBookById(id);

        if (book == null || !book.isIssued()) {
            return false;
        }

        book.returnBook();
        return true;
    }
}