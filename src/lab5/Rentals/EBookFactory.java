package lab5.Rentals;

public class EBookFactory extends BookFactory {


	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setIsAvailable(boolean isAvailable) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Book createBook(String title) {
		EBook ebook = new EBook(title);
		return ebook;
	}

}
