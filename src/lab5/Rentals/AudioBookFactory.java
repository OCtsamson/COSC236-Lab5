package lab5.Rentals;

public class AudioBookFactory extends BookFactory {

	
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
		AudioBook audiobook = new AudioBook(title);
		return audiobook;
	}

}
