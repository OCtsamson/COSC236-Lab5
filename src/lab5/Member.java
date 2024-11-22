package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(Book book) {
		if(new BorrowingService().borrowBook(this, book)) {
			System.out.println("Borrowing book: " + book);
		}else {
			System.out.println("Borrowing failed!");
		}
	}
	public void returnBook(Book book) {
		if(new BorrowingService().returnBook(this, book)) {
			System.out.println("Returning book: " + book);
		}else {
			System.out.println("Returning failed!");
		}
	}
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 Book book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
}
