package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import lab5.*;
import lab5.Borrowing.BorrowingService;
import lab5.Rentals.AudioBook;
import lab5.Rentals.Book;
import lab5.Rentals.EBook;
import lab5.Rentals.PaperBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestAddRemoveBooks {
	
	private Library library;
	private BorrowingService service;

	Member member;
	
	@BeforeEach
	void setUp() throws Exception {
		this.service = BorrowingService.getInstance();
		this.library = new Library(); // empty library for each test

		member = new Member("Grady Booch", service);
	}

	Book book1 = new PaperBook("Dune");
	Book book2 = new EBook("1984");
	Book book3 = new AudioBook("Moby Dick");
	
	@Test
	void AddBooks() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
	}
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook(book2);
		library.removeBook(book3);
		assertEquals(library.booksCount(), 1, "There should be only one book left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook("Dune");
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		
		member.borrowBook(book1);
		assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");
		
		library.removeBook(book1);
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
		
		assertEquals(member.borrowedBooksCount(), 1, "The book should stay with member"); // 
		
		Book b = member.getBorrowedBooks().get(0); // the only book
		assertEquals(b, book1,"The owned book should be the removed book");
	}
	
	
}
