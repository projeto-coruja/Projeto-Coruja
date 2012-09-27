package business.EJB.user;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.UserAccount;

import business.DAO.login.UserDAO;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public class SearchUserEJB {

	UserDAO user;

	public SearchUserEJB() {
		user = new UserDAO();
	}

	public List<DTO> listUsers() throws UnreachableDataBaseException, UserNotFoundException{
		return user.listAllUsers();
	}

	public UserAccount findUser(String email) throws UnreachableDataBaseException, UserNotFoundException{
		return user.findUserByEmail(email);
	}
	
}
