package business.exceptions.documents;

public class DuplicateOriginException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1123937683286049875L;

	public DuplicateOriginException() {
		super();
	}
	
	public DuplicateOriginException(String msg) {
		super(msg);
	}

	public DuplicateOriginException(Throwable arg0) {
		super(arg0);
	}

	public DuplicateOriginException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DuplicateOriginException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
