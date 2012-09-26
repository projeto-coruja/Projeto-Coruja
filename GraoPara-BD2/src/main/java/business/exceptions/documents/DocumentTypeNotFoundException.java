package business.exceptions.documents;

public class DocumentTypeNotFoundException extends Exception {

	private static final long serialVersionUID = -3411642901984003059L;

	public DocumentTypeNotFoundException() {
		super();
	}

	public DocumentTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DocumentTypeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DocumentTypeNotFoundException(String message) {
		super(message);
	}

	public DocumentTypeNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
