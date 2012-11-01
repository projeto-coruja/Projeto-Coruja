package business.DAO.login;

import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.Profile;
import persistence.dto.UserAccount;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public class UserDAO {

	private PersistenceAccess manager;

	public UserDAO() {
		manager = new PersistenceAccess();
	}
	
	public UserAccount findUserByEmail(String email) throws UnreachableDataBaseException, UserNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from UserAccountMO where email = '" + email +"'");
			if(resultSet == null) {
				throw new UserNotFoundException("Email não encontrado");
			}
			else return (UserAccount) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void addUser(String email, String name, String password, Profile profile) throws UnreachableDataBaseException {
		UserAccount newUser;
		if(profile == null){
			newUser = new UserAccount(name, ProfileDAO.getDefaultProfile(), email, password);
		}
		else{
			newUser = new UserAccount(name, profile, email, password);
		}
		try {
			manager.saveEntity(newUser);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> listAllUsers() throws UnreachableDataBaseException, UserNotFoundException {
		List<DTO> resultSet;
		try{
			resultSet = null;
			resultSet = manager.findEntity("from UserAccountMO order by name");
			if(resultSet == null)	throw new UserNotFoundException("Nenhum usuário encontrado");
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
		return resultSet;
	}
	
	public void removeUser(String email) throws UnreachableDataBaseException, UserNotFoundException{
		UserAccount check = null;
		try{
			check = findUserByEmail(email);
			manager.deleteEntity(check);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void changeUserProfile(String email, Profile new_profile) throws IncorrectProfileInformationException, UnreachableDataBaseException, UserNotFoundException, IllegalArgumentException, UpdateEntityException {
		UserAccount check = null;
		try {
			check = findUserByEmail(email);
			if(check == null) throw new UserNotFoundException("Usuário não existe!");
			String old_profile = check.getProfile().getProfile();
			if(old_profile != new_profile.getProfile()) check.setProfile(new_profile);
			else throw new IncorrectProfileInformationException("Perfil já definido para esse usuário, escolha outro.");
			manager.updateEntity(check);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void updateUser(UserAccount user) throws UnreachableDataBaseException, UserNotFoundException, IllegalArgumentException, UpdateEntityException{
		if(user.getId() == null){
			user = this.findUserByEmail(user.getEmail());
			if(user == null)	throw new UserNotFoundException("Usuário não encontrado");
		}
		else{
			try{
				manager.updateEntity(user);
			}catch(DataAccessLayerException e){
				e.printStackTrace();
				throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
			}
		}
	}
	
	public List<DTO> listUsersByProfile(String profileName) throws UnreachableDataBaseException, ProfileNotFoundException, UserNotFoundException {
		List<DTO> resultSet = null;
		ProfileDAO profileDAO = null;
		
		try{
			profileDAO = new ProfileDAO();
			Profile profile = profileDAO.findProfileByName(profileName);
			if(profile == null)	throw new ProfileNotFoundException();
			resultSet = null;
			resultSet = manager.findEntity("from UserAccountMO where name = '" + profile.getId() + "' order by name");
			if(resultSet == null)	throw new UserNotFoundException("Nenhum usuário encontrado");
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
		return resultSet;
	}
	
}
