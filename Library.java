import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int id;
    private boolean issued;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.issued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public void updateDetails(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + issued;
    }
}

class Library {
    private ArrayList<Book> books;
    private Scanner scanner;

    public Library() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void insertBook() {
        System.out.println("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.println("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        books.add(new Book(title, author, id));
        System.out.println("Book added successfully!");
    }

    public void searchBook() {
        System.out.println("Enter Book Title to search: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
            }
        }
    }

    public void updateBookDetails() {
        System.out.println("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("Enter new Title: ");
                String title = scanner.nextLine();
                System.out.println("Enter new Author: ");
                String author = scanner.nextLine();
                book.updateDetails(title, author);
                System.out.println("Book details updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void issueBook() {
        System.out.println("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isIssued()) {
                    book.setIssued(true);
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void returnBook() {
        System.out.println("Enter Book ID to return: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isIssued()) {
                    book.setIssued(false);
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void collectFine() {
        System.out.println("Enter Book ID to collect fine: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("Enter the amount of fine: ");
        double fine = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("Collected fine of $" + fine + " for book ID: " + id);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void displayMenu() {
        System.out.println("\nLibrary Management System Menu:");
        System.out.println("1. Insert new Book");
        System.out.println("2. Search for book(s)");
        System.out.println("3. Update book details");
        System.out.println("4. Issue book to a student");
        System.out.println("5. Return book from a student");
        System.out.println("6. Collect fine if any");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    insertBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    updateBookDetails();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    collectFine();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.run();
    }
}