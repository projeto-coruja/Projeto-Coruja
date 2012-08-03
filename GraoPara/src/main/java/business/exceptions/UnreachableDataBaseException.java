package business.exceptions;

import javax.security.auth.login.LoginException;

public class UnreachableDataBaseException extends LoginException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -620020735955249556L;
	
	public UnreachableDataBaseException(){
		super();
	}
	
	public UnreachableDataBaseException(String msg){
		super(msg);
	}

}
