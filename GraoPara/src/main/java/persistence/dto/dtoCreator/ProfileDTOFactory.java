package persistence.dto.dtoCreator;

import persistence.dto.ProfileDTO;
import persistence.model.Entidade;
import persistence.model.Profile;

public class ProfileDTOFactory implements DTOFactory {


	/**
	 * @see persistence.dto.dtoCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public ProfileDTO createDTO(Entidade entity) {
		ProfileDTO newDTO = new ProfileDTO();
		Profile entry = (Profile) entity;
		newDTO.setId(entry.getId());
		newDTO.setProfile(entry.getProfile());
		newDTO.setEdit(entry.getEdit());
		newDTO.setRead(entry.getRead());
		newDTO.setWrite(entry.getWrite());
		
		return newDTO;
	}

}
