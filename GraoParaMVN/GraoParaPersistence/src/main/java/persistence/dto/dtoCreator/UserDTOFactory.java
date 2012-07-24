package persistence.dto.dtoCreator;

import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;
import persistence.model.Entidade;
import persistence.model.User;

public class UserDTOFactory implements DTOFactory {
	
	/**
	 * @see persistence.dto.dtoCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public UserDTO createDTO(Entidade entity) {
		UserDTO newDTO = new UserDTO();
		User entry = (User) entity;
		newDTO.setId(entry.getId());
		newDTO.setEmail(entry.getEmail());
		newDTO.setName(entry.getName());
		newDTO.setPassword(entry.getPassword());
		newDTO.setUserProfile(getProfileDTO(entry));
		
		return newDTO;
	}
	
	
	private ProfileDTO getProfileDTO(User entry) {
		DTOFactory aux_factory = new ProfileDTOFactory();
		return (ProfileDTO) aux_factory.createDTO(entry.getUserProfile());
	}
}
