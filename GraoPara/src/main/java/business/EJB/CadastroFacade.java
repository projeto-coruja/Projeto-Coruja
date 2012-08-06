package business.EJB;

import business.DAO.LoginDAO;
import business.exceptions.DuplicateUserException;
import business.exceptions.IncorrectLoginInformationException;
import business.exceptions.UnreachableDataBaseException;
import persistence.dto.UserDTO;

public class CadastroFacade {

	private LoginDAO loginDAO;

	private final String emailPattern = "([A-Za-z0-9])([A-Za-z0-9]|_|-|.)*@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)+";
	private final RegularExpression emailChecker = new RegularExpression(emailPattern);
	
	
	public CadastroFacade() {
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
