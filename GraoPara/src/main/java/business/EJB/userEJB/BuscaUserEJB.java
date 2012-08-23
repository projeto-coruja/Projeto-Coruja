package business.EJB.userEJB;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.UserDTO;

import business.DAO.login.LoginDAO;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public class BuscaUserEJB {
	
	LoginDAO user;
	
	public BuscaUserEJB() {
		user = new LoginDAO();
	}
	
	public List<DTO> listUsers() throws UnreachableDataBaseException, UserNotFoundException{
		return user.listAllUsers();
	}
	
	public UserDTO findUser(String email) throws UnreachableDataBaseException, UserNotFoundException{
		return user.findUserByEmail(email);
	}

}
