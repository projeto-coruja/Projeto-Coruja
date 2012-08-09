package business.exceptions.documents;

public class IdNumDocumentNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3145193790696123557L;

	public IdNumDocumentNotFoundException() {
		super();
	}

	public IdNumDocumentNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IdNumDocumentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public IdNumDocumentNotFoundException(String message) {
		super(message);
	}

	public IdNumDocumentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
