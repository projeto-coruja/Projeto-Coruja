package business.EJB.user;

import persistence.dto.UserAccount;
import business.DAO.login.UserDAO;
import business.EJB.util.EJBUtility;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public class AuthBean {

	private static UserDAO loginDAO = new UserDAO();

	public final static boolean HashedPwd = true;
	public final static boolean NonHashedPwd = false;

	public final static String LoginFailOrDefault = "f7904905535ed808ce600ea013c1ec4e471507ef0563adcd1d93f87d38608c47";
	public final static String LoginSuccessUser = "4f077f41bf2610da31dc152a26bd950fe2a55dfe51a8e2968c581ef151c9df08";
	public final static String LoginSuccessAdmin = "ccdb36d8fe6fbecdec96b11f3c776987688d43ea2293576f20af7b54351c6e65";

	public static UserBean validarLogin(String email, String password, boolean hashed) throws UnreachableDataBaseException, UserNotFoundException {

		UserAccount check = loginDAO.findUserByEmail(email);
		if(check == null)
			return null;

		String hashedPassword = null;
		if(hashed == NonHashedPwd)
			hashedPassword = EJBUtility.getHash(password, "MD5");
		else
			hashedPassword = password;

		if (check.getPassword().equals(hashedPassword))
		{
			UserBean result = new UserBean();
			result.setEmail(email);
			result.setUsername(check.getName());
			String profile = check.getProfile().getName();
			
			if(profile.equals("admin"))			result.setLogType(LoginSuccessAdmin);
			
			else if(profile.equals("user"))		result.setLogType(LoginSuccessUser);
			
			else								result.setLogType(LoginFailOrDefault);

			return result;
		}
		else
			return null;
	}

	public static boolean allowOperation(String sessionCode, String email, String username, String status) {
		String hashcode = EJBUtility.getHash(username + email + status, "SHA-256");
		if(sessionCode.equals(hashcode))	return true;
		return false;

	}
	
}
