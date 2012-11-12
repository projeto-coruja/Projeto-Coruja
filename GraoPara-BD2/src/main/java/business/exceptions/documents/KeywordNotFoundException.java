package business.exceptions.documents;

public class KeywordNotFoundException extends Exception {

	private static final long serialVersionUID = 149172638994485821L;

	public KeywordNotFoundException() {
		super();
	}

	public KeywordNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public KeywordNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public KeywordNotFoundException(String msg) {
		super(msg);
	}

	public KeywordNotFoundException(Throwable arg0) {
		super(arg0);
	}
	
}
