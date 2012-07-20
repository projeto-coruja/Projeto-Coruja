package Persistence.DTO.DTOCreator;

import Persistence.DTO.ProfileDTO;
import Persistence.DTO.UserDTO;
import Persistence.Model.User;

public class UserDTOFactory implements DTOFactory {
	
	/**
	 * @see Persistence.DTO.DTOCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public UserDTO createDTO(Object entity) {
		UserDTO newDTO = new UserDTO();
		User entry = (User) entity;
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
