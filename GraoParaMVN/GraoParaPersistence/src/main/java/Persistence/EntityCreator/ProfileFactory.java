package Persistence.EntityCreator;

import Persistence.DTO.ProfileDTO;
import Persistence.Model.Profile;

public class ProfileFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public Profile createEntity(Object dto) {
		Profile newEnt = new Profile();
		ProfileDTO entry = (ProfileDTO) dto;
		
		newEnt.setProfile(entry.getProfile());
		newEnt.setEdit(entry.isEdit());
		newEnt.setRead(entry.isRead());
		newEnt.setWrite(entry.isWrite());
		
		return newEnt;
	}

}
