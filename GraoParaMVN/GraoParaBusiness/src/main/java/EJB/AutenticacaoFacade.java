package EJB;

import persistence.dto.UserDTO;
import DAO.LoginDAO;

public class AutenticacaoFacade {

	private LoginDAO loginDAO;
	
	public AutenticacaoFacade() {
		loginDAO = new LoginDAO();
	}
	
	public void validarLogin(String email, String password) {
		UserDTO check = loginDAO.findUserByEmail(email);
		if(check != null) {
			String hashedPassword = Password.getHash(password);
			if(check.getPassword().equals(hashedPassword)) {
				//TODO: código de autenticação e etc
				System.out.println("validarLogin: OK");
			}
			else {
				//TODO: throw exception
			}
		}
		else {
			//TODO: throw exception
		}

	}

}
