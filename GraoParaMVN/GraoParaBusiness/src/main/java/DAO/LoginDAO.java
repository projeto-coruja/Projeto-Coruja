package DAO;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;
import persistence.utility.DataAccessLayerException;

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

	public UserDTO findUserByEmail(String email) throws LoginException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from User where email = '" + email +"'");
			if(resultSet == null) {
				throw new LoginException("Email não encontrado no banco de dados.");
			}
			else return (UserDTO) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new LoginException("Erro no banco de dados.");
		}
	}
	
	public List<DTO> findUsersByName(String name) throws LoginException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from User where name like '" + name +"'");
			if(resultSet == null) {
				throw new LoginException("Não existe usuário com esse nome.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new LoginException("Erro no banco de dados.");
		}
	}

	public void addUser(String email, String name, String password) {
		UserDTO newUser = new UserDTO(name, password, defaultProfile, email, new Date());
		manager.saveEntity(newUser);
	}
	
	public void removeUser(String email) throws LoginException{
		UserDTO check = findUserByEmail(email);
		manager.deleteEntity(check);
	}

}
