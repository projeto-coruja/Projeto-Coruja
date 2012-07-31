package EJB;

import exceptions.IncorrectLoginInformationException;
import exceptions.IncorrectProfileInformationException;
import exceptions.ProfileNotFoundException;
import exceptions.UnreachableDataBaseException;
import exceptions.UserNotFoundException;
import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;
import DAO.LoginDAO;

public class CadastroFacade {

	private LoginDAO loginDAO;
	
	public CadastroFacade() {
		loginDAO = new LoginDAO();
	}

	public void validacaoCadastro(String email, String password, String name) throws IncorrectLoginInformationException, UnreachableDataBaseException {
		try {
			@SuppressWarnings("unused")
			UserDTO check = loginDAO.findUserByEmail(email);
			throw new IncorrectLoginInformationException("Email já existe.");
		} catch (UserNotFoundException e) {
			loginDAO.addUser(email, name, password);
		}
	}
	
	public void adicionarUsuario(String email, String name, String password) throws UnreachableDataBaseException {
		try {
			UserDTO check = loginDAO.findUserByEmail(email);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			loginDAO.addUser(email, name, password);
			e.printStackTrace();
		}
	}
	
	public void adicionarProfile(String profile, boolean read, boolean write, boolean edit) throws UnreachableDataBaseException, IncorrectProfileInformationException {
		try {
			@SuppressWarnings("unused")
			ProfileDTO check = loginDAO.findProfileByName(profile);
			throw new IncorrectProfileInformationException("Nome de profile já existe.");
		} catch(ProfileNotFoundException e) {
			loginDAO.createProfile(profile, read, write, edit);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
