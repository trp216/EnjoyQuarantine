package exceptions;

public class DifferentPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DifferentPasswordException() {
		super("The passwords are different. Please try again.");
	}

}
