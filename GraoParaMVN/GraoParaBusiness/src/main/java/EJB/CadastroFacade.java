package EJB;

import exceptions.IncorrectLoginInformationException;
import exceptions.UnreachableDataBaseException;
import exceptions.UserNotFoundException;
import persistence.dto.UserDTO;
import DAO.LoginDAO;

public class CadastroFacade {

	private LoginDAO loginDAO;

	private final String emailPattern = "([A-Za-z0-9]+)([A-Za-z0-9]|_|-|.)*@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)+";
	private final RegularExpression emailChecker = new RegularExpression(emailPattern);
	
	
	public CadastroFacade() {
		loginDAO = new LoginDAO();
	}

	public void validacaoCadastro(String email, String password, String name) throws IncorrectLoginInformationException, UnreachableDataBaseException {
		try {
			@SuppressWarnings("unused")
			UserDTO check = loginDAO.findUserByEmail(email);
			throw new IncorrectLoginInformationException("Email já existe.");
		} catch (UserNotFoundException e) {
			loginDAO.addUser(email, name, password);
		}
	}
	
	public void adicionarUsuario(String email, String name, String password) throws UnreachableDataBaseException, IncorrectLoginInformationException {
		try {
			if(!emailChecker.check(email))	throw new IncorrectLoginInformationException("Email inválido");	
			@SuppressWarnings("unused")
			UserDTO check = loginDAO.findUserByEmail(email);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			loginDAO.addUser(email, name, Password.getHash(password));
			//e.printStackTrace();
		}
	}

}
