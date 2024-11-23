package lab5.Borrowing;

import lab5.Member;
import lab5.Rentals.Book;

public interface BorrowingServiceAPI {
	public BorrowingBookResult borrowBook(Member member, Book book);
	public BorrowingBookResult returnBook(Member member, Book book);
}
