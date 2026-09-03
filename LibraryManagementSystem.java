import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryService library = new LibraryService();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);

        if (library.addBook(book)) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book ID already exists.");
        }
    }

    private static void viewBooks() {
        if (library.getAllBooks().isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book book : library.getAllBooks()) {
            book.displayBook();
        }
    }

    private static void searchBook() {
        System.out.print("Enter Book ID: ");
        Book book = library.findBookById(scanner.nextInt());

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            book.displayBook();
        }
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();

        if (library.issueBook(id)) {
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book not found or already issued.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();

        if (library.returnBook(id)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book not found or was not issued.");
        }
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();

        if (library.deleteBook(id)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }
}