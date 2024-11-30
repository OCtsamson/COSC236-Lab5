package lab5.Rentals;

public abstract class BookFactory implements Book {
	public abstract Book createBook(String title);
}
