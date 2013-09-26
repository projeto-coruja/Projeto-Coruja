package business.EJB.user;

import persistence.dto.UserAccount;
import business.DAO.login.UserDAO;
import business.EJB.util.EJBUtility;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Classe de autenticação de usuário.
 */
public class AuthBean {

	private static UserDAO loginDAO = new UserDAO();

	public final static boolean HashedPwd = true;
	public final static boolean NonHashedPwd = false;

	// Hashs para validação de perfil do usuário.
	public final static String LoginFailOrDefault = "f7904905535ed808ce600ea013c1ec4e471507ef0563adcd1d93f87d38608c47";
	public final static String LoginSuccessUserLevel1 = "626f2659243587c96bc858517f36d8766c493d4adc6efd45e1b6d0edbdecf666";
	public final static String LoginSuccessUserLevel2 = "e04394eb555584278715d567be41e47638a0bf0fe00612bcbceea89e6c3a69c2";
	public final static String LoginSuccessAdmin = "ccdb36d8fe6fbecdec96b11f3c776987688d43ea2293576f20af7b54351c6e65";

	/**
	 * Valida um novo login
	 * @param email - Email
	 * @param password - Senha
	 * @param hashed - Flag indicando se a senha vai ser hasheado ou não. (False para debug).
	 * @return <tt>UserBean</tt> do usuário.
	 * @throws UnreachableDataBaseException
	 * @throws UserNotFoundException quando o não há usuário com o email fornecido.
	 */
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
			String profile = check.getProfile().getProfile();
			
			if(profile.equals("admin"))	result.setLogType(LoginSuccessAdmin);
			else if(profile.equals("user1")) result.setLogType(LoginSuccessUserLevel1);
			else if(profile.equals("user2")) result.setLogType(LoginSuccessUserLevel2);
			else result.setLogType(LoginFailOrDefault);

			return result;
		}
		else
			return null;
	}

	/**
	 * Verifica as permissões do usuário.
	 * @param sessionCode - hash de sessão do usuário.
	 * @param email
	 * @param username
	 * @param status
	 * @return <b>True</b> se o usuário tem permissão para executar uma determinada ação. <b>False</b> caso contrário.
	 */
	public static boolean allowOperation(String sessionCode, String email, String username, String status) {
		String hashcode = EJBUtility.getHash(username + email + status, "SHA-256");
		if(sessionCode.equals(hashcode))	return true;
		return false;

	}
	
}
