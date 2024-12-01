package lab5.Rentals;

import lab5.Library;

public class PaperBookFactory extends BookFactory {

	
	@Override
	public Book createBook(String title) {
		return new PaperBook(title);
	}
	
	public PaperBookFactory(Library library) {
		super(library);
	}

}
