package lab5.Rentals;

public class EBook implements Book {

	private String title;
	private boolean isAvailable;

	public EBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		return "E-Book: " + title;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
}
