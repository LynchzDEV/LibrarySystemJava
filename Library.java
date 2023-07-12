package librarymanagement;

public class Library {
    private Book[] books;
    private int capacity;  
    private int numBooks;  // Number of books currently in the library

    // Constructor
    public Library(int capacity) {
        books = new Book[capacity];
        this.capacity = capacity;
        numBooks = 0; 
    }

    // Add a book to the library
    public void addBook(Book book) {
        if (numBooks < capacity) {
            books[numBooks] = book;
            numBooks++;
            System.out.println("Book added to the library.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Display all available books
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < numBooks; i++) {
            Book book = books[i];
            if (book.isAvailable()) {
                System.out.println("Book title: " + book.getTitle() + "  Book author: " + book.getAuthor());
            }
        }
    }

    // Borrow a book
    public void borrowBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have successfully borrowed the book: " + book.getTitle());
            } else {
                System.out.println("Sorry, the book is currently unavailable.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    // Return a book
    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            if (!book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You have successfully returned the book: " + book.getTitle());
            } else {
                System.out.println("You have already returned this book.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    // Helper method to find a book by title
    private Book findBookByTitle(String title) {
        for (int i = 0; i < numBooks; i++) {
            Book book = books[i];
            if (book.getTitle().equalsIgnoreCase(title)) { // .equalsIgnoreCase() is used to compare strings ignoring case 
                return book;
            }
        }
        return null;
    }
}
