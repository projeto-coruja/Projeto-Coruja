package Persistence.DTO.DTOCreator;

import Persistence.DTO.ProfileDTO;
import Persistence.Model.Profile;

public class ProfileDTOFactory implements DTOFactory {


	/**
	 * @see Persistence.DTO.DTOCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public ProfileDTO createDTO(Object entity) {
		ProfileDTO newDTO = new ProfileDTO();
		Profile entry = (Profile) entity;
		newDTO.setProfile(entry.getProfile());
		
		return newDTO;
	}

}
