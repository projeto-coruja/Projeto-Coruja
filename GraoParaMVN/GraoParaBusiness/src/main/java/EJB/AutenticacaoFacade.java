package EJB;

import exceptions.IncorrectLoginInformationException;
import exceptions.UnreachableDataBaseException;
import exceptions.UserNotFoundException;

import persistence.dto.UserDTO;
import DAO.LoginDAO;

public class AutenticacaoFacade {

	private LoginDAO loginDAO;
	
	public AutenticacaoFacade() {
		loginDAO = new LoginDAO();
	}
	
	public boolean validarLogin(String email, String password) throws IncorrectLoginInformationException,  UserNotFoundException, UnreachableDataBaseException{
		UserDTO check = null;
		try {
			check = loginDAO.findUserByEmail(email);
			String hashedPassword = Password.getHash(password);
			if(check.getPassword().equals(hashedPassword)) {
				return true;
			}
			else {
				throw new IncorrectLoginInformationException("Senha incorreta.");
			}
		} catch (IncorrectLoginInformationException e) {
			e.printStackTrace();
//			throw e;
			return false;
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return false;
//			throw e;
		}
	}
	
}
