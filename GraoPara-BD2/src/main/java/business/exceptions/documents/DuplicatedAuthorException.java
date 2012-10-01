package business.exceptions.documents;

public class DuplicatedAuthorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatedAuthorException() {
		super();
	}

	public DuplicatedAuthorException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicatedAuthorException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicatedAuthorException(String message) {
		super(message);
	}

	public DuplicatedAuthorException(Throwable cause) {
		super(cause);
	}

}
