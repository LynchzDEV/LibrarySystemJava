import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private int capacity;

    // Constructor
    public Library(int capacity) {
        books = new ArrayList<>();
        this.capacity = capacity;
    }

    // Add a book to the library
    public void addBook(Book book) {
        if (books.size() < capacity) {
            books.add(book);
            System.out.println("Book added to the library.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Display all available books
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }

    // Borrow a book
    public void borrowBook(String title) {
        for (Book book : books) {
            if (compareTitles(book.getTitle(), title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("You have successfully borrowed the book: " + book.getTitle());
                    return;
                } else {
                    System.out.println("Sorry, the book is currently unavailable.");
                    return;
                }
            }
        }
        System.out.println("Book not found in the library.");
    }

    // Return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (compareTitles(book.getTitle(), title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("You have successfully returned the book: " + book.getTitle());
                    return;
                } else {
                    System.out.println("You have already returned this book.");
                    return;
                }
            }
        }
        System.out.println("Book not found in the library.");
    }

    // Compare two titles character by character
    private boolean compareTitles(String title1, String title2) {
        if (title1.length() != title2.length()) {
            return false;
        }
        for (int i = 0; i < title1.length(); i++) {
            char c1 = title1.charAt(i);
            char c2 = title2.charAt(i);
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
        }
        return true;
    }
}
