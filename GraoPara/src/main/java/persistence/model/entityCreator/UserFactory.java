package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.dto.UserDTO;
import persistence.model.Entidade;
import persistence.model.Profile;
import persistence.model.User;

public class UserFactory implements EntityFactory {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade createEntity(DTO dto) {
		User newEnt = new User();
		UserDTO entry = (UserDTO) dto;

		newEnt.setEmail(entry.getEmail());
		newEnt.setName(entry.getName());
		newEnt.setPassword(entry.getPassword());
		newEnt.setUserProfile(getProfile(entry));
		newEnt.setDataInclusao(entry.getDataInclusao());
		
		return newEnt;
	}
	
	
	private Profile getProfile(UserDTO entry) {
		EntityFactory aux_factory = new ProfileFactory();
		return (Profile) aux_factory.createEntity(entry.getUserProfile());
	}

}
