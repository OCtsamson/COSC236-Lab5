package lab5;

public class BorrowingService implements BorrowingServiceAPI{
	public BorrowingBookResult borrowBook(Member m, Book book) {
		if (book != null && m != null) {
			if(!book.getIsAvailable()) {
				return new BorrowingBookResult(false, "Book is not available!");
			}
			if(m.getBorrowedBooks().contains(book)) {
				return new BorrowingBookResult(false, "Member already borrowed this book!");
			}
			if(m.getBorrowedBooks().size() >= 3) {
				return new BorrowingBookResult(false, "Member has reached their borrowing limit!");
			}
			book.setIsAvailable(false);
			m.getBorrowedBooks().add(book);
			return new BorrowingBookResult(true, "Borrowing book: " + book);
		}
		return new BorrowingBookResult(false, "Borrowing failed!");
	}
	public BorrowingBookResult returnBook(Member m, Book book) {
		if (book != null && m != null) {
			if(!m.getBorrowedBooks().contains(book)) {
				return new BorrowingBookResult(false, "Member has not borrowed this book!");
			}
			if(book.getIsAvailable()) {
				return new BorrowingBookResult(false, "Book has already been returned!");
			}
			book.setIsAvailable(true);
			m.getBorrowedBooks().remove(book);
			return new BorrowingBookResult(true, "Returning book: " + book);
		}
		return new BorrowingBookResult(false, "Returning failed!");
	}
}
