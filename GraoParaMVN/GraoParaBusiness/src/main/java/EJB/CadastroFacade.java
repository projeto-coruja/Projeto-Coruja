package EJB;

import DAO.LoginDAO;

public class CadastroFacade {

	private LoginDAO loginDAO;
	
	public CadastroFacade() {
		loginDAO = new LoginDAO();
	}

	public void validacaoCadastro(String email, String password, String name) {
		
	}

}
