package business.exceptions.documents;

public class DuplicateCodiceCaixaException extends Exception {

	private static final long serialVersionUID = -1123937683286049875L;

	public DuplicateCodiceCaixaException() {
		super();
	}

	public DuplicateCodiceCaixaException(String msg) {
		super(msg);
	}

	public DuplicateCodiceCaixaException(Throwable arg0) {
		super(arg0);
	}

	public DuplicateCodiceCaixaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DuplicateCodiceCaixaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
}
