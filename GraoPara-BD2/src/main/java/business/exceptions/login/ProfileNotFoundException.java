package business.exceptions.login;

import javax.security.auth.login.LoginException;

public class ProfileNotFoundException extends LoginException {
	
	private static final long serialVersionUID = 1L;
	
	public ProfileNotFoundException() {
	}

	public ProfileNotFoundException(String msg) {
		super(msg);
	}

}
