package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.UserDTO;
import persistence.model.Entidade;
import persistence.model.Profile;
import persistence.model.User;

public class UserUpdater implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		UserDTO entry = (UserDTO) dto;
		
		((User) ent).setId(entry.getId());
		((User) ent).setEmail(entry.getEmail());
		((User) ent).setName(entry.getName());
		((User) ent).setPassword(entry.getPassword());
		((User) ent).setUserProfile(getProfile(entry, ent));
		
		return ent;
	}
	
	
	private Profile getProfile(UserDTO dto, Entidade ent) {
		EntityUpdate aux_update = new ProfileUpdater();
		return (Profile) aux_update.updateEntity(dto.getUserProfile(), ((User) ent).getUserProfile());
	}

}
