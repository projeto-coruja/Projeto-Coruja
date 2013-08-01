package business.EJB.user;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.UserAccount;

import business.DAO.login.UserDAO;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * busca básica de usuário.
 */
public class SearchUserBean {

	UserDAO user;

	public SearchUserBean() {
		user = new UserDAO();
	}

	/**
	 * Retorna uma lista de todos usuários.
	 * @return <tt>List&lt;DTO&gt;</tt> contendo todos os usuários.
	 * @throws UnreachableDataBaseException
	 * @throws UserNotFoundException
	 */
	public List<DTO> listUsers() throws UnreachableDataBaseException, UserNotFoundException{
		return user.listAllUsers();
	}

	/**
	 * Busca um usuário através do email.
	 * @param email - Email do usuário.
	 * @return <i>UserAccount</i> do usuário desejado.
	 * @throws UnreachableDataBaseException
	 * @throws UserNotFoundException
	 */
	public UserAccount findUser(String email) throws UnreachableDataBaseException, UserNotFoundException{
		return user.findUserByEmail(email);
	}
	
}
