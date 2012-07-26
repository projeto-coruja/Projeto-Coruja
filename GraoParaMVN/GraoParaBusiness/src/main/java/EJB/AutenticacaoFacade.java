package EJB;

import exceptions.IncorrectLoginInformationException;
import exceptions.UnreachableDataBaseException;

import persistence.dto.UserDTO;
import DAO.LoginDAO;

public class AutenticacaoFacade {

	private LoginDAO loginDAO;
	
	public AutenticacaoFacade() {
		loginDAO = new LoginDAO();
	}
	
	public void validarLogin(String email, String password) throws IncorrectLoginInformationException, UnreachableDataBaseException{
		UserDTO check = null;
		try {
			check = loginDAO.findUserByEmail(email);
			String hashedPassword = Password.getHash(password);
			if(check.getPassword().equals(hashedPassword)) {
				//TODO faz algo
			}
			else {
				throw new IncorrectLoginInformationException("Senha incorreta.");
			}
		} catch (IncorrectLoginInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
}
