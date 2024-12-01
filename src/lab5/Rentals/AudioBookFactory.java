package lab5.Rentals;

import lab5.Library;

public class AudioBookFactory extends BookFactory {

	public AudioBookFactory(Library library) {
		super(library);
	}
	
	@Override
	public Book createBook(String title) {
		return new AudioBook(title);
	}

}
