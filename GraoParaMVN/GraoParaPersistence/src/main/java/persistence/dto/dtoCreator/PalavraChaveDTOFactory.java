package persistence.dto.dtoCreator;

import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;
import persistence.model.Entidade;
import persistence.model.PalavraChave;

public class PalavraChaveDTOFactory implements DTOFactory {


	/**
	 * @see persistence.dto.dtoCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public DTO createDTO(Entidade entity) {
		PalavraChaveDTO newDTO = new PalavraChaveDTO();
		PalavraChave entry = (PalavraChave) entity;
		newDTO.setId(entry.getId());
		newDTO.setPalavra(entry.getPalavra());
		newDTO.setAprovada(entry.isAprovada());
		
		return newDTO;
	}

}
