package lab5.Rentals;

import lab5.Library;

public class UnsupportedBookFactory extends BookFactory {
	
	public UnsupportedBookFactory(Library library) {
		super(library);
	}
	
	@Override
	public Book createBook(String title) {
		return null;
	}
}
