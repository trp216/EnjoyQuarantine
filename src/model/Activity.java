package model;

public class Activity {
	
	private Activity prev, next;
	
	private String text;

	public Activity getPrev() {
		return prev;
	}

	public void setPrev(Activity prev) {
		this.prev = prev;
	}

	public Activity getNext() {
		return next;
	}

	public void setNext(Activity next) {
		this.next = next;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
