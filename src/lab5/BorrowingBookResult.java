package lab5;

public class BorrowingBookResult {
	private boolean isSuccess;
	private String borrowingMessage;
	public BorrowingBookResult(boolean isSuccess, String borrowingMessage) {
		this.isSuccess = isSuccess;
		this.borrowingMessage = borrowingMessage;
	}
	public String getBorrowingMessage() {
		return this.borrowingMessage;
	}
	public boolean getIsSuccess() {
		return this.isSuccess;
	}
	public void setBorrowingMessage(String s) {
		this.borrowingMessage = s;
	}
	public void setIsSuccess(boolean b) {
		this.isSuccess = b;
	}
	public String toString() {
		return this.borrowingMessage;
	}
}
