package business.exceptions.documents;

public class DuplicatedDocumentTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicatedDocumentTypeException() {
		super();
	}

	public DuplicatedDocumentTypeException(String message) {
		super(message);
	}

}
