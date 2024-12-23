package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.Borrowing.BorrowingService;
import lab5.Rentals.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Rentals.PaperBook;
import lab5.Member;

class TestNotAvailablePaperBook {
	private BorrowingService service;

	Member member1;
	Member member2;
	
	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	
	@BeforeEach
	void setUp() throws Exception {
		service = BorrowingService.getInstance();
		member1 = new Member("Alice", service); // flush borrowedBook array
		member2 = new Member("Bob", service);   // flush borrowedBook array
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
	}
	@Test
	void tryToBorrowBookBook() {
		
		// first member borrows a book
		
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed books should be zero");
		assertEquals(member2.borrowedBooksCount(), 0, "Borrowed books should be zero");
		
		assertTrue(book1.getIsAvailable(), "Book should be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(), "Book should be borrowed");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of borrowed books must be 1");
		
		// second member borrows the same book 
		member2.borrowBook(book1);
		assertFalse(book1.getIsAvailable(), "Book should still be borrowed" );
		assertEquals(member1.borrowedBooksCount(), 1, "Member should have one book");
		assertEquals(member2.borrowedBooksCount(), 0, "Member should have no books after rejection");
		
		// first member returns the book 
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		
		// second member borrows the same book 
		member2.borrowBook(book1);
		
		assertFalse(book1.getIsAvailable(), "Book should be borrowed");
		assertEquals(member1.borrowedBooksCount(), 0, "Member should have no borrowed books");
		assertEquals(member2.borrowedBooksCount(), 1, "Member should have one book");
		
			
	}

}
