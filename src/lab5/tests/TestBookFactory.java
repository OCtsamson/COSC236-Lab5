package lab5.tests;

import lab5.LibrarianController;
import lab5.Library;
import lab5.Rentals.AudioBookFactory;
import lab5.Rentals.BookFactory;
import lab5.Rentals.EBookFactory;
import lab5.Rentals.PaperBookFactory;

public class TestBookFactory {

	private BookFactory factory;
	private AudioBookFactory afactory;
	private EBookFactory efactory; 
	private PaperBookFactory pfactory;
	private Library library;
	private LibrarianController lcontroller;
	
	void testBookFactory() { 
		lcontroller.addBook(afactory, "Dune");
		lcontroller.addBook(efactory, "Moby Dick");
		lcontroller.addBook(pfactory, "1984");
		
		asserttrue(lcontroller.get instanceof AudioBook);
	}
}
