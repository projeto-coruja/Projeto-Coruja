package persistence.exceptions;

public class UpdateEntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateEntityException() {
		super();
	}

	public UpdateEntityException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdateEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateEntityException(String message) {
		super(message);
	}

	public UpdateEntityException(Throwable cause) {
		super(cause);
	}
	
}
