public class Book {
    private final int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public void displayBook() {
        System.out.println("------------------------------");
        System.out.println("Book ID : " + id);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Status  : " + (issued ? "Issued" : "Available"));
        System.out.println("------------------------------");
    }
}