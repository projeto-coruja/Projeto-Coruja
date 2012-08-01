package EJB;

import persistence.dto.ProfileDTO;
import exceptions.IncorrectProfileInformationException;
import exceptions.ProfileNotFoundException;
import exceptions.UnreachableDataBaseException;
import exceptions.UserNotFoundException;
import DAO.LoginDAO;

public class AdminFacade {
	
	private LoginDAO loginDAO;
	
	public AdminFacade() {
		loginDAO = new LoginDAO();
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
	
	public void alterarPermissoesUsuario(String email, String novo_perfil) throws IncorrectProfileInformationException, UnreachableDataBaseException, UserNotFoundException, ProfileNotFoundException {
		loginDAO.changeUserProfile(email, loginDAO.findProfileByName(novo_perfil));
	}
	
	public void deletarUsuario(String email) throws UnreachableDataBaseException, UserNotFoundException {
		loginDAO.removeUser(email);
	}

}
