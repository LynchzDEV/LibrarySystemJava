package librarymanagement;

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
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isAvailable()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }

    // Borrow a book
    public void borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
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
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
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
}
