package DAO;

import java.util.Date;
import java.util.List;


import exceptions.IncorrectLoginInformationException;
import exceptions.UnreachableDataBaseException;

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

	public UserDTO findUserByEmail(String email) throws IncorrectLoginInformationException, UnreachableDataBaseException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from User where email = '" + email +"'");
			if(resultSet == null) {
				throw new IncorrectLoginInformationException("Email não encontrado");
			}
			else return (UserDTO) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findUsersByName(String name) throws IncorrectLoginInformationException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from User where name like '" + name +"'");
			if(resultSet == null) {
				throw new IncorrectLoginInformationException("Usuário não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

	public void addUser(String email, String name, String password) throws UnreachableDataBaseException {
		UserDTO newUser = new UserDTO(name, password, defaultProfile, email, new Date());
		try {
			manager.saveEntity(newUser);
		} catch(DataAccessLayerException e){
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void removeUser(String email) throws UnreachableDataBaseException, IncorrectLoginInformationException{
		UserDTO check = null;
		try{
			check = findUserByEmail(email);
			manager.deleteEntity(check);
		} catch(DataAccessLayerException e){
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

}
