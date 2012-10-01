package business.exceptions.documents;

public class AuthorNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorNotFoundException() {
		super();
	}

	public AuthorNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthorNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthorNotFoundException(String message) {
		super(message);
	}

	public AuthorNotFoundException(Throwable cause) {
		super(cause);
	}

}
