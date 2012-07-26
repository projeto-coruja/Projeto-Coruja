package DAO;

import java.util.Date;
import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;

public class LoginDAO {
	
	private PersistenceAccess manager;
	private static ProfileDTO defaultProfile;

	public LoginDAO() {
		manager = new PersistenceAccess();
		if(defaultProfile != null)
		{
			defaultProfile = new ProfileDTO("default", false, true, false);
		}
	}

	public UserDTO findUserByEmail(String email) {
		List<DTO> resultSet = manager.findEntities("from User where email = '" + email +"'");
		if(resultSet != null) return (UserDTO) resultSet.get(0);
		else {
			//TODO: exceção aqui
			System.out.println("UserDTO findUserByEmail(String email), email não existe");
			return null;
		}
	}

	public void addUser(String email, String name, String password) {
		UserDTO newUser = new UserDTO(name, password, defaultProfile, email, new Date());
		manager.saveEntity(newUser);
	}
	
	public void removeUser(String email) {
		List<DTO> resultSet = manager.findEntities("from User where email = '" + email +"'");
		if(resultSet != null) manager.deleteEntity(resultSet.get(0));
		else {
			//TODO: exceção aqui
			System.out.println("removeUser(String email), email não existe");
		}
	}

}
