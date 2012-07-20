package Persistence.DTO.DTOCreator;

import Persistence.DTO.ProfileDTO;
import Persistence.Model.Profile;

public class ProfileDTOFactory implements DTOFactory {


	public ProfileDTO createDTO(Object entity) {
		ProfileDTO newDTO = new ProfileDTO();
		Profile entry = (Profile) entity;
		newDTO.setProfile(entry.getProfile());
		newDTO.setWrite(entry.getWrite());
		newDTO.setEdit(entry.getEdit());
		newDTO.setRead(entry.getRead());
		return newDTO;
	}

}
