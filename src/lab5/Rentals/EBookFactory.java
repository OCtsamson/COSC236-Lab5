package lab5.Rentals;

import lab5.Library;

public class EBookFactory extends BookFactory {


	public EBookFactory(Library library) {
		super(library);
	}
	
	@Override
	public Book createBook(String title) {
		return new EBook(title);
	}

}
