package exceptions;

import javax.security.auth.login.LoginException;

public class IncorrectProfileInformationException extends LoginException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectProfileInformationException() {
		super();
	}

	public IncorrectProfileInformationException(String msg) {
		super(msg);
	}

}
