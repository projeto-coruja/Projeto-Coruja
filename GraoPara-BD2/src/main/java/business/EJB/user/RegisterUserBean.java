package business.EJB.user;

import persistence.dto.UserAccount;
import persistence.exceptions.UpdateEntityException;
import business.DAO.login.UserDAO;
import business.EJB.util.EJBUtility;
import business.EJB.util.RegularExpression;
import business.EJB.util.SendMail;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * classe de registro de usuário
 */
public class RegisterUserBean {

	private UserDAO userDAO;
	
	private final String emailPattern = "([A-Za-z0-9])([_.-]?[A-Za-z0-9])*@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)+";
	private final RegularExpression emailChecker = new RegularExpression(emailPattern);
	
	public RegisterUserBean() {
		userDAO = new UserDAO();
	}
	
	/**
	 * Adiciona um novo usuário.
	 * @param email - Email do usuário
	 * @param password - Senha do usuário.
	 * @param name - Nome do usuário.
	 * @throws IncorrectLoginInformationException quando o email possue um padrão incorreto.
	 * @throws DuplicateUserException quando o email fornecido já existe no banco de dados.
	 */
	public void addUser(String email, String password, String name) throws IncorrectLoginInformationException, DuplicateUserException{
		try {
			if(!emailChecker.check(email))	throw new IncorrectLoginInformationException("Email inválido");	
			UserAccount check;
			try {
				check = userDAO.findUserByEmail(email);
				if(check != null)	throw new DuplicateUserException();
			} catch (UserNotFoundException e) {
				userDAO.addUser(email, name, EJBUtility.getHash(password, "MD5"), null);
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Recuperação de senha de usuário.
	 * @param email - Email do usuário.
	 * @return Nova senha.
	 * @throws UnreachableDataBaseException quando há algum problema na comunicação com o BD.
	 * @throws UserNotFoundException quando o não há usuário com o email fornecido.
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException quando há algum problema na atualização da entrada no BD.
	 */
	public String recuperarSenha(String email) throws UnreachableDataBaseException, UserNotFoundException, IllegalArgumentException, UpdateEntityException {
		UserAccount user = userDAO.findUserByEmail(email);
		String newPassword = EJBUtility.genRandomString(6);
		user.setPassword(EJBUtility.getHash(newPassword, "MD5"));
		userDAO.updateUser(user);
		try{
			SendMail.send(user.getEmail(), "Sua nova senha do Grão Pará!", "Aqui está a sua nova senha do Grão Pará.\n\n"+newPassword);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return newPassword;
	}

	/**
	 * Atualiza os dados de um usuário.
	 * @param user - <tt>UserAccount</tt> do usuário
	 * @throws UnreachableDataBaseException quando há algum problema na comunicação com o BD.
	 * @throws UserNotFoundException
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException
	 */
	public void atualizarUsuario(UserAccount user) throws UnreachableDataBaseException, UserNotFoundException, IllegalArgumentException, UpdateEntityException{
		userDAO.updateUser(user);
	}
	
}
