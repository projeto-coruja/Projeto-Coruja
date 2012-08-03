package business.EJB;

import business.DAO.LoginDAO;
import business.exceptions.UnreachableDataBaseException;
import business.exceptions.UserNotFoundException;

import persistence.dto.UserDTO;

public class AutenticacaoFacade {

	private LoginDAO loginDAO;

	public AutenticacaoFacade() {
		loginDAO = new LoginDAO();
	}

	public boolean validarLogin(String email, String password) throws UnreachableDataBaseException {
		
		UserDTO check = null;
		try {
			check = loginDAO.findUserByEmail(email);
		} catch(UserNotFoundException e) {
			return false;
		}
		
		String hashedPassword = Password.getHash(password);
		if (check.getPassword().equals(hashedPassword))
			return true;
		else
			return false;
	}

}
