package EJB;

import javax.security.auth.login.LoginException;

import persistence.dto.UserDTO;
import DAO.LoginDAO;

public class AutenticacaoFacade {

	private LoginDAO loginDAO;
	
	public AutenticacaoFacade() {
		loginDAO = new LoginDAO();
	}
	
	public void validarLogin(String email, String password) throws LoginException{
		UserDTO check = null;
		try {
			check = loginDAO.findUserByEmail(email);
			String hashedPassword = Password.getHash(password);
			if(check.getPassword().equals(hashedPassword)) {
				//TODO faz algo
			}
			else {
				throw new LoginException("Senha incorreta.");
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
}
