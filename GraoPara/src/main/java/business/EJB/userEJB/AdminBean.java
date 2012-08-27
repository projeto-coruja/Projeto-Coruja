package business.EJB.userEJB;

import java.util.List;

import business.DAO.login.LoginDAO;
import business.EJB.RegularExpression;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;
import persistence.dto.DTO;
import persistence.dto.ProfileDTO;

public class AdminBean {
	
	private LoginDAO loginDAO;
	
	private final String profileNamePattern = "([a-z0-9]){3,}";
	private final RegularExpression profileNameChecker = new RegularExpression(profileNamePattern);
	
	public AdminBean() {
		loginDAO = new LoginDAO();
	}
	
	public void adicionarProfile(String profile, boolean read, boolean write, boolean edit) throws UnreachableDataBaseException, IncorrectProfileInformationException {
		try {
			if(!profileNameChecker.check(profile))	throw new IncorrectProfileInformationException("Nome inválido");
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

	public List<DTO> getAllAvailableProfiles() throws UnreachableDataBaseException, ProfileNotFoundException{
		return loginDAO.getAllProfiles();
	}
}
