package lab5;

import lab5.Borrowing.BorrowingService;
import lab5.Rentals.Book;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private BorrowingService service;
	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	
	public Member(String name, BorrowingService borrowService) {
		this.service = borrowService;
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
		System.out.println(service.borrowBook(this, book));
	}
	public void returnBook(Book book) {
		System.out.println(service.returnBook(this, book));
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
