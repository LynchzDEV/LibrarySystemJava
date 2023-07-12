package librarymanagement;

public class Library {
    private Book[] books;
    private int capacity;
    private int numBooks;

    public Library(int capacity) {
        books = new Book[capacity];
        this.capacity = capacity;
        numBooks = 0;
    }

    public void addBook(Book book) {
        if (numBooks < capacity) {
            books[numBooks] = book;
            numBooks++;
            System.out.println("Book added to the library.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < numBooks; i++) {
            Book book = books[i];
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

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

    private Book findBookByTitle(String title) {
        for (int i = 0; i < numBooks; i++) {
            Book book = books[i];
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
