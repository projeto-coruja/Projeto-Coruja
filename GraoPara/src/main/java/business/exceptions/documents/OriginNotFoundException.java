package business.exceptions.documents;

public class OriginNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1123937683286049875L;

	public OriginNotFoundException() {
		super();
	}
	
	public OriginNotFoundException(String msg) {
		super(msg);
	}

	public OriginNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public OriginNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OriginNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
