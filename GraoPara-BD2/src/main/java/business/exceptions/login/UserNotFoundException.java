package business.exceptions.login;

import javax.security.auth.login.LoginException;

public class UserNotFoundException extends LoginException  {

	private static final long serialVersionUID = -5124200239009089574L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String msg){
		super(msg);
	}

}