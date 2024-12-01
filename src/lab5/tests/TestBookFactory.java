package lab5.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.print.Book;

import lab5.LibrarianController;
import lab5.Library;
import lab5.Rentals.AudioBook;
import lab5.Rentals.AudioBookFactory;
import lab5.Rentals.EBook;
import lab5.Rentals.EBookFactory;
import lab5.Rentals.PaperBook;
import lab5.Rentals.PaperBookFactory;
import lab5.Rentals.UnsupportedBookFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBookFactory {

    private AudioBookFactory afactory;
    private EBookFactory efactory; 
    private PaperBookFactory pfactory;
    private UnsupportedBookFactory ufactory;
    private Library library;
    private LibrarianController lcontroller;

    @BeforeEach
    public void setUp() {
        library = new Library(); 
        afactory = new AudioBookFactory(library); 
        efactory = new EBookFactory(library);
        pfactory = new PaperBookFactory(library);
        ufactory = new UnsupportedBookFactory(library);
        lcontroller = new LibrarianController(); 
    }

    @Test
    void testBookFactory() {
        
        lcontroller.addBook(afactory, "Dune");
        lcontroller.addBook(efactory,"Moby Dick");
        lcontroller.addBook(pfactory,"1984");
        lcontroller.addBook(ufactory, "Ip Man");
        
      
        assertTrue(lcontroller.findBookByTitle("Dune") instanceof AudioBook, "Dune should be an AudioBook");
        assertTrue(lcontroller.findBookByTitle("Moby Dick") instanceof EBook, "Moby Dick should be an EBook");
        assertTrue(lcontroller.findBookByTitle("1984") instanceof PaperBook, "1984 should be a PaperBook");
        
        assertFalse(lcontroller.findBookByTitle("Ip Man") instanceof Book, "Unsupported");

    }
    
}
