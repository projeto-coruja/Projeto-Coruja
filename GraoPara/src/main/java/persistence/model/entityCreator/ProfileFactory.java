package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.model.Profile;

public class ProfileFactory implements EntityFactory {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Profile createEntity(DTO dto) {
		Profile newEnt = new Profile();
		ProfileDTO entry = (ProfileDTO) dto;
		
		newEnt.setId(entry.getId());
		newEnt.setProfile(entry.getProfile());
		newEnt.setEdit(entry.isEdit());
		newEnt.setRead(entry.isRead());
		newEnt.setWrite(entry.isWrite());
		
		return newEnt;
	}

}
