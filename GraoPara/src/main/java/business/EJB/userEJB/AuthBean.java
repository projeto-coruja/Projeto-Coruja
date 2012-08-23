package business.EJB.userEJB;

import business.DAO.login.LoginDAO;
import business.EJB.util.EJBUtility;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

import persistence.dto.UserDTO;

public class AuthBean {

	private static LoginDAO loginDAO = new LoginDAO();
	
	public final static boolean HashedPwd = true;
	public final static boolean NonHashedPwd = false;
	
	public final static int LoginFailOrDefault = 0;
	public final static int LoginSuccessUser = 1;
	public final static int LoginSuccessAdmin = 2;

	public static UserBean validarLogin(String email, String password, boolean hashed) throws UnreachableDataBaseException, UserNotFoundException {

		UserDTO check = loginDAO.findUserByEmail(email);
		if(check == null)
			return null;
		
		String hashedPassword = null;
		if(hashed == NonHashedPwd)
			hashedPassword = EJBUtility.getHash(password);
		else
			hashedPassword = password;
		
		if (check.getPassword().equals(hashedPassword))
		{
			UserBean result = new UserBean();
			result.setEmail(email);
			result.setUsername(check.getName());
			String profile = check.getUserProfile().getProfile();
			if(profile.equals("admin")){
				result.setLogType(LoginSuccessAdmin);
			}
			else if(profile.equals("user"))
				result.setLogType(LoginSuccessUser);
			else
				result.setLogType(LoginFailOrDefault);
			
			return result;
		}
		else
			return null;
	}

}
