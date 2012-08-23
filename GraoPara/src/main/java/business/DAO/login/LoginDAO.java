package business.DAO.login;

import java.util.Date;
import java.util.List;

import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

//import exceptions.IncorrectLoginInformationException;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;
import persistence.utility.DataAccessLayerException;

public class LoginDAO {

	private static ProfileDTO defaultProfile;
	private static String defaultProfileName = "default";
	
	private PersistenceAccess manager;

	public LoginDAO() {
		manager = new PersistenceAccess();
		getDefaultProfile();
	}
	
	private void getDefaultProfile() { 
		if(defaultProfile == null) {	
			try {
				defaultProfile = this.findProfileByName(defaultProfileName);
			} catch (UnreachableDataBaseException e) {
				e.printStackTrace();
			} catch (ProfileNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public UserDTO findUserByEmail(String email) throws UnreachableDataBaseException, UserNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from User where email = '" + email +"'");
			if(resultSet == null) {
				throw new UserNotFoundException("Email não encontrado");
//				return null;
			}
			else return (UserDTO) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findUsersByName(String name) throws  UserNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from User where name like '%" + name +"%'");
			if(resultSet == null) {
				throw new  UserNotFoundException("Usuário não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> listUsersByProfile(String profileName) throws UnreachableDataBaseException, ProfileNotFoundException, UserNotFoundException {
		List<DTO> resultSet = null;
		try{
			ProfileDTO profile = this.findProfileByName(profileName);
			if(profile == null)	throw new ProfileNotFoundException();
			resultSet = null;
			resultSet = manager.findEntities("from User where profile = '" + profile.getId() + "'");
			if(resultSet == null)	throw new UserNotFoundException("Nenhum usuário encontrado");
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
		return resultSet;
	}
	
	public List<DTO> listAllUsers() throws UnreachableDataBaseException, UserNotFoundException {
		List<DTO> resultSet;
		try{
			resultSet = null;
			resultSet = manager.findEntities("from User order by name");
			if(resultSet == null)	throw new UserNotFoundException("Nenhum usuário encontrado");
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
		return resultSet;
	}

	public void addUser(String email, String name, String password) throws UnreachableDataBaseException {
		UserDTO newUser = new UserDTO(name, password, LoginDAO.defaultProfile, email, new Date());
		try {
			manager.saveEntity(newUser);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void removeUser(String email) throws UnreachableDataBaseException, UserNotFoundException{
		UserDTO check = null;
		try{
			check = findUserByEmail(email);
			manager.deleteEntity(check);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void changeUserProfile(String email, ProfileDTO new_profile) throws IncorrectProfileInformationException, UnreachableDataBaseException, UserNotFoundException {
		UserDTO check = null;
		try {
			check = findUserByEmail(email);
			if(check == null) throw new UserNotFoundException("Usuário não existe!");
			String old_profile = check.getUserProfile().getProfile();
			if(old_profile != new_profile.getProfile()) check.setUserProfile(new_profile);
			else throw new IncorrectProfileInformationException("Perfil já definido para esse usuário, escolha outro.");
			manager.updateEntity(check);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void createProfile(String profile, boolean read, boolean write, boolean edit) throws UnreachableDataBaseException{
		ProfileDTO newProfile = new ProfileDTO(profile, write, read, edit);
		try {
			manager.saveEntity(newProfile);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public ProfileDTO findProfileByName(String profile) throws UnreachableDataBaseException, ProfileNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Profile where profile = '" + profile + "'");
			if(resultSet == null) {
				throw new ProfileNotFoundException();
			}
			else return (ProfileDTO) resultSet.get(0);
		} catch(DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void updateUser(UserDTO user) throws UnreachableDataBaseException, UserNotFoundException{
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

}
