package exceptions;

import javax.security.auth.login.LoginException;

public class IncorrectLoginInformationException extends LoginException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8898790142799139943L;
	
	public IncorrectLoginInformationException() {
		super();
	}
	
	public IncorrectLoginInformationException(String msg) {
		super(msg);
	}
	

}
