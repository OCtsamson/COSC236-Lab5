package lab5;

public class BorrowingService implements BorrowingServiceAPI{
	public boolean borrowBook(Member m, Book book) {
		if (book != null && m != null && book.getIsAvailable()) {
			book.setIsAvailable(false);
			m.getBorrowedBooks().add(book);
			return true;
		}
		return false;
	}
	public boolean returnBook(Member m, Book book) {
		if (book != null && m != null && m.getBorrowedBooks().contains(book)) {
			book.setIsAvailable(true);
			m.getBorrowedBooks().remove(book);
			System.out.println("Returning book: " + book);
			return true;
		}
		return false;
	}
}
