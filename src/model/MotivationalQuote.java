package model;

public class MotivationalQuote extends CheerUser{
	
	private MotivationalQuote left;
	
	private  MotivationalQuote right;
	
	
	public MotivationalQuote() {
	}

	public MotivationalQuote getLeft() {
		return left;
	}

	public void setLeft(MotivationalQuote left) {
		this.left = left;
	}

	public MotivationalQuote getRight() {
		return right;
	}

	public void setRight(MotivationalQuote right) {
		this.right = right;
	}
	
	

}
