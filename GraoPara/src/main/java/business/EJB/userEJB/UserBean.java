package business.EJB.userEJB;

import business.DAO.login.LoginDAO;

public class UserBean {
	
	private String nomeUser;
	private LoginDAO loginDAO;
	
	public UserBean() {
		loginDAO = new LoginDAO();
	}
	
	public void getNomeUser() {
		
	}

}
