package business.EJB;

import business.DAO.LoginDAO;
import business.exceptions.UnreachableDataBaseException;

import persistence.dto.UserDTO;

public class AuthBean {

	private static LoginDAO loginDAO = new LoginDAO();
	
	public final static boolean HashedPwd = true;
	public final static boolean NonHashedPwd = false;
	
	public final static int LoginFail = 0;
	public final static int LoginSuccessUser = 1;
	public final static int LoginSuccessAdmin = 2;

	public static int validarLogin(String email, String password, boolean hashed) throws UnreachableDataBaseException {

		UserDTO check = loginDAO.findUserByEmail(email);
		if(check == null)
			return LoginFail;
		
		String hashedPassword = null;
		if(hashed == NonHashedPwd)
			hashedPassword = Password.getHash(password);
		else
			hashedPassword = password;
		
		if (check.getPassword().equals(hashedPassword))
		{
			if(check.getUserProfile().getProfile().equals("admin"))
				return LoginSuccessAdmin;
			else
				return LoginSuccessUser;
		}
		else
			return LoginFail;
	}

}
