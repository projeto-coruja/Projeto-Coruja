package persistence.util;

public class DataAccessLayerException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2147894645311728508L;

	public DataAccessLayerException() {
    }

    public DataAccessLayerException(String message) {
        super(message);
    }

    public DataAccessLayerException(Throwable cause) {
        super(cause);
    }

    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}

