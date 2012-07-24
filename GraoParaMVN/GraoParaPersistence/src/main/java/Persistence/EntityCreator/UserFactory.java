package Persistence.EntityCreator;

import Persistence.DTO.DTO;
import Persistence.DTO.UserDTO;
import Persistence.Model.Entidade;
import Persistence.Model.Profile;
import Persistence.Model.User;

public class UserFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade createEntity(DTO dto) {
		User newEnt = new User();
		UserDTO entry = (UserDTO) dto;
		
		newEnt.setEmail(entry.getEmail());
		newEnt.setName(entry.getName());
		newEnt.setPassword(entry.getPassword());
		newEnt.setUserProfile(getProfile(entry));
		
		return newEnt;
	}
	
	
	private Profile getProfile(UserDTO entry) {
		EntityFactory aux_factory = new ProfileFactory();
		return (Profile) aux_factory.createEntity(entry.getUserProfile());
	}

}
