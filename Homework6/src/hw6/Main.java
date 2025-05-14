package hw6;

import java.util.ArrayList;
import java.util.Scanner;

class book {
	String title;
	String author;
	String isbn;
	boolean isAvaliable;
	
	// Method to set constructors for the book added
	public book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isAvaliable = true; // Set to true by default
	}
	
	// toString() method to allow displaying all information
	public String toString() {
		return "\nTitle: " + title +
				"\nAuthor: " + author +
				"\nISBN: " + isbn +
				"\nAvaliable: " + isAvaliable +
				"\n";
	}
	
	// Getters
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public boolean isAvaliable() {
		return isAvaliable;
	}
	
}

// Class library is where the main methods are created and used from
class library {
	
	public static ArrayList<book> books = new ArrayList<>();
	
	static boolean search;
	
	Scanner scanner = new Scanner(System.in);
	
	// Method to add new books
	public static void addBook(book book) {
		for (book b : books) {
			// Possible error handling if book has already been added
			if (b.getIsbn().equals(book.getIsbn())) {
				System.out.println("A book with this ISBN was already added.");
				return;
			}
		}
		books.add(book);
		System.out.println("Book has been added.");
	}
	
	// Method to remove books
	public static void removeBook (String isbn) {
		for (book b : books) {
			if (b.getIsbn().equals(isbn)) {
				books.remove(b);
				System.out.println("Book has been removed.");
				return;
			}
			// Possible error handling if book does not exist
				System.out.println("Error: Book does not exist");
		}
	}
	
	public static void displayAllBooks() {
		System.out.println("Books in library:");
		for (book b: books) {
			System.out.println(b);
		}
	}
	
	public static void searchByTitle(String title) {
		search = false;
		for (book b : books) {
			if (b.getTitle().equalsIgnoreCase(title)) {
				System.out.print(b);
				search = true;
				
			}
		}
			if (!search) {
				System.out.println("Could not find book searched.");
				
			}
		
	}
	
	public static void searchByAuthor(String author) {
		search = false;
		for (book b : books) {
			if (b.getAuthor().equalsIgnoreCase(author)) {
				System.out.print(b);
				search = true;
			}
		}
			if (!search) {
				System.out.println("Could not find book searched.");
			}
		
	}
	
	public static void checkOutBook(String isbn) {
		for (book b : books) {
			if (b.getIsbn().equalsIgnoreCase(isbn)) {
				// In case book is already checked out
				if (b.isAvaliable == false) {
					System.out.println("Book is already checked out.");
					return;
				}
				// Set b (book selected) avaliability to false
				b.isAvaliable = false;
				System.out.println("Book has been checked out.");
				return;
			}
		}
	}
	
	public static void returnBook(String isbn) {
		for (book b : books) {
			if (b.getIsbn().equalsIgnoreCase(isbn)) {
				// In case book is already avaliable
				if (b.isAvaliable == true) {
					System.out.println("Book is already avaliable.");
					return;
				}
				// Set b (book selected) avaliability to true
				b.isAvaliable = true;
				System.out.println("Book has been returned.");
				return;
			}
		}
	}

	
}


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int choice;
		
		// Display menu options
		System.out.println("Welcome to Library Management System!");
		System.out.println("----------------------------------");
		System.out.println("1. Add Book");
		System.out.println("2. Remove Book");
		System.out.println("3. Display All Books");
		System.out.println("4. Search by Title");
		System.out.println("5. Search by Author");
		System.out.println("6. Check Out Book");
		System.out.println("7. Return Book");
		System.out.println("8. Exit");
		
		// While loop to keep the system running
		while (true) {
		System.out.print("\nEnter your choice (1 - 8): ");

		choice = scanner.nextInt();
		scanner.nextLine();
		
		// Switch used for user selection with menu
		switch(choice) {
			case 1:
				System.out.println("Enter title: ");
				String title = scanner.nextLine(); // Get input for the title
				
				System.out.println("Enter author: ");
				String author = scanner.nextLine(); // Get input for the author
				
				System.out.println("Enter ISBN: ");
				String isbn = scanner.nextLine(); // Get input for the ISBN
				
				library.addBook(new book(title, author, isbn)); // Putting the title, author, and ISBN into a new book
				break;
			
			case 2:
				System.out.println("Enter the ISBN of the book you'd like to remove:");
				isbn = scanner.nextLine();
				library.removeBook(isbn);
				break;
				
			case 3:
				library.displayAllBooks();
				break;
			
			case 4:
				System.out.println("Enter the title: ");
				title = scanner.nextLine();
				library.searchByTitle(title);
				break;
				
			case 5:
				System.out.println("Enter the author: ");
				author = scanner.nextLine();
				library.searchByAuthor(author);
				break;
				
			case 6:
				System.out.println("Enter the ISBN to check out: ");
				isbn = scanner.nextLine();
				library.checkOutBook(isbn);
				break;
				
			case 7:
				System.out.println("Enter the ISBN to return: ");
				isbn = scanner.nextLine();
				library.returnBook(isbn);
				break;
				
			case 8:
				System.out.println("Exiting, have a nice day.");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid input, please try again.");
			
			}
			
		}

	}
}


