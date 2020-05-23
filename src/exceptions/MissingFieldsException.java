package exceptions;

public class MissingFieldsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MissingFieldsException() {
		super("It seems like you are missing some fields");
	}

}
