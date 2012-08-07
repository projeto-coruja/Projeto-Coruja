package business.exceptions.login;

import javax.security.auth.login.LoginException;

public class DuplicateUserException extends LoginException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8043678488175983272L;

	public DuplicateUserException() {
		super();
	}
	
	public DuplicateUserException(String msg) {
		super(msg);
	}

}
