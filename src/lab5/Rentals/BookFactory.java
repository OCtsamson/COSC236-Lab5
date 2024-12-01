package lab5.Rentals;

import lab5.Library;

public abstract class BookFactory  {
	public abstract Book createBook(String title);
	
	private Library library;
	
	public BookFactory(Library library) { 
		this.library = library;
	}
}
