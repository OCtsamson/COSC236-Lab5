package lab5.tests;

import lab5.*;
import lab5.Borrowing.BorrowingService;
import lab5.Rentals.AudioBook;
import lab5.Rentals.Book;
import lab5.Rentals.EBook;
import lab5.Rentals.PaperBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBorrowingServices {

	private BorrowingService service;

	Member member1;

	Book book1 = new PaperBook("Animal Farm");
	Book book2 = new AudioBook("1914");
	Book book3 = new EBook("The Big Friendly Giant");

	@BeforeEach
	void setUp() throws Exception {
		service = BorrowingService.getInstance();
		member1 = new Member("Kevin", service); // flush borrowedBook array
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
		book3.setIsAvailable(false);
	}

	@Test
	void tryBorrowingServices() {
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed books should be zero");

		assertTrue(book1.getIsAvailable(), "Book should be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(), "Book should be borrowed");

		member1.borrowBook(book2);
		assertEquals(member1.borrowedBooksCount(), 2, "Borrowed books should be two");
		member1.borrowBook(book1);
		assertEquals(member1.borrowedBooksCount(), 2, "Borrowed books should still be two");
		assertFalse(book1.getIsAvailable(), "Book should still be borrowed" );

		member1.returnBook(book1);
		assertEquals(member1.borrowedBooksCount(), 1, "Borrowed books should be one");
		assertTrue(book1.getIsAvailable(), "Book should be returned" );
		member1.returnBook(book1);
		assertEquals(member1.borrowedBooksCount(), 1, "Borrowed books should still be one");
		assertTrue(book1.getIsAvailable(), "Book should have already been returned" );

		member1.returnBook(book3);
		assertFalse(book3.getIsAvailable(), "Book was not taken out by this member" );

		member1.borrowBook(book3);
		assertEquals(member1.borrowedBooksCount(), 1, "Borrowed books should still be one");
		assertFalse(book3.getIsAvailable(), "Book cannot be borrowed as it has been already" );
	}
}
