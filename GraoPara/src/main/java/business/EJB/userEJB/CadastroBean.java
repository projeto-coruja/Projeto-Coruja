package business.EJB.userEJB;

import business.DAO.login.LoginDAO;
import business.EJB.RegularExpression;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.dto.UserDTO;

public class CadastroBean {

	private LoginDAO loginDAO;

	private final String emailPattern = "([A-Za-z0-9])([A-Za-z0-9]|_|-|.)*@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)+";
	private final RegularExpression emailChecker = new RegularExpression(emailPattern);
	
	
	public CadastroBean() {
		loginDAO = new LoginDAO();
	}
	
	public void adicionarUsuario(String email, String name, String password) throws UnreachableDataBaseException, IncorrectLoginInformationException, DuplicateUserException {
		try {
			if(!emailChecker.check(email))	throw new IncorrectLoginInformationException("Email inválido");	
			UserDTO check = loginDAO.findUserByEmail(email);
			if(check != null)
				throw new DuplicateUserException();
			else
				loginDAO.addUser(email, name, Password.getHash(password));
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		}
	}

}
