package business.EJB;

import business.DAO.LoginDAO;
import business.exceptions.UnreachableDataBaseException;

import persistence.dto.UserDTO;

public class AuthBean {

	private static LoginDAO loginDAO = new LoginDAO();
	
	public static boolean HashedPwd = true;
	public static boolean NonHashedPwd = false;

	public static boolean validarLogin(String email, String password, boolean hashed) throws UnreachableDataBaseException {

		UserDTO check = loginDAO.findUserByEmail(email);
		if(check == null)
			return false;
		
		String hashedPassword = null;
		if(hashed == NonHashedPwd)
			hashedPassword = Password.getHash(password);
		else
			hashedPassword = password;
		
		if (check.getPassword().equals(hashedPassword))
			return true;
		else
			return false;
	}

}
