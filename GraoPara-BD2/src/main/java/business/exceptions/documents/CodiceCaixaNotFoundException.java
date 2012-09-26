package business.exceptions.documents;

public class CodiceCaixaNotFoundException extends Exception {

	private static final long serialVersionUID = -1123937683286049875L;

	public CodiceCaixaNotFoundException() {
		super();
	}

	public CodiceCaixaNotFoundException(String msg) {
		super(msg);
	}

	public CodiceCaixaNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public CodiceCaixaNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CodiceCaixaNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
}
