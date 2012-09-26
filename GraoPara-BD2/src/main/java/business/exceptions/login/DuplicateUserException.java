package business.exceptions.login;

public class DuplicateUserException extends Exception {

	private static final long serialVersionUID = 8043678488175983272L;

	public DuplicateUserException() {
		super();
	}

	public DuplicateUserException(String msg) {
		super(msg);
	}
	
}
