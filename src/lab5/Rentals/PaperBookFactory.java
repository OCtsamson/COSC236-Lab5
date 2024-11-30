package lab5.Rentals;

public class PaperBookFactory extends BookFactory {

	
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setIsAvailable(boolean isAvailable) {
	}

	
	public boolean getIsAvailable() {
		return false;
	}

	
	public Book createBook(String title) {
		PaperBook paperbook = new PaperBook(title);
		return paperbook;
	}

}
