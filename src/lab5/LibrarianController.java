package lab5;

import lab5.Borrowing.BorrowingService;
import lab5.Rentals.AudioBook;
import lab5.Rentals.AudioBookFactory;
import lab5.Rentals.Book;
import lab5.Rentals.BookFactory;
import lab5.Rentals.EBook;
import lab5.Rentals.EBookFactory;
import lab5.Rentals.PaperBook;
import lab5.Rentals.PaperBookFactory;

public class LibrarianController {
	
	private Library library; // Library dependency
	private BorrowingService borrowingService;
	private AudioBookFactory audioBookFactory;
	private EBookFactory eBookFactory;
	private PaperBookFactory paperBookFactory;
	
	public LibrarianController( ) {
		this.library = new Library(); // Constructor injection
		this.borrowingService = BorrowingService.getInstance();
		this.paperBookFactory = new PaperBookFactory(library);
		this.eBookFactory = new EBookFactory(library);
		this.audioBookFactory = new AudioBookFactory(library);
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addPaperBook(String title) {
		library.addBook(paperBookFactory.createBook(title));  // Book class constructor dependency
	}
	public void addEBook(String title) {
		library.addBook(eBookFactory.createBook(title));
	} // Add E-Book
	public void addAudioBook(String title) {
		library.addBook(audioBookFactory.createBook(title));
	} //Add Audio-Book
	
	public void addBook(BookFactory factory, String title) { 
		library.addBook(factory.createBook(title));
	}
	public void addMember(String name) {
		library.addMember(new Member(name, borrowingService)); // Member class constructor dependency
	}
	public Book findBookByTitle(String title) { 
		return library.findBookByTitle(title);
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title);  // use library for search
		if (book != null && member != null)
			member.borrowBook(book); // member borrows a book, not library 
		else 	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search
		if (book != null && member != null)
			member.returnBook(book); // members returns book. 
		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
}
