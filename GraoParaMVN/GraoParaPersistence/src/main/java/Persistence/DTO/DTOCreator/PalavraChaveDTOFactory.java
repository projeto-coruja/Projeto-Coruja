package Persistence.DTO.DTOCreator;

import Persistence.DTO.DTO;
import Persistence.DTO.PalavraChaveDTO;
import Persistence.Model.Entidade;
import Persistence.Model.PalavraChave;

public class PalavraChaveDTOFactory implements DTOFactory {


	/**
	 * @see Persistence.DTO.DTOCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public DTO createDTO(Entidade entity) {
		PalavraChaveDTO newDTO = new PalavraChaveDTO();
		PalavraChave entry = (PalavraChave) entity;
		newDTO.setPalavra(entry.getPalavra());
		newDTO.setAprovada(entry.isAprovada());
		
		return newDTO;
	}

}
