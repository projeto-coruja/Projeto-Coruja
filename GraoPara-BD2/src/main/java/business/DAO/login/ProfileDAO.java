package business.DAO.login;

import java.util.List;

import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.Profile;
import persistence.util.DataAccessLayerException;

public class ProfileDAO {

	private static Profile defaultProfile;
	
	private static final String defaultProfileName = "default";

	private PersistenceAccess manager;
	
	public ProfileDAO() {
		manager = new PersistenceAccess();
		initDefaultProfile();
	}
	
	public static Profile getDefaultProfile(){
		return defaultProfile;
	}
	
	private void initDefaultProfile() { 
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
	
	public void createProfile(String profile) throws UnreachableDataBaseException{
		Profile newProfile = new Profile(profile);
		try {
			manager.saveEntity(newProfile);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public Profile findProfileByName(String profile) throws UnreachableDataBaseException, ProfileNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from ProfileMO where name = '" + profile + "'");
			if(resultSet == null) {
				throw new ProfileNotFoundException();
			}
			else return (Profile) resultSet.get(0);
		} catch(DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> getAllProfiles() throws UnreachableDataBaseException, ProfileNotFoundException{
		List<DTO> resultSet = null;
		try{
			resultSet = manager.findEntity("from ProfileMO order by name");
			if(resultSet == null)	throw new ProfileNotFoundException("Nenhum perfil encontrado");
			else return resultSet;
		} catch(DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
}
