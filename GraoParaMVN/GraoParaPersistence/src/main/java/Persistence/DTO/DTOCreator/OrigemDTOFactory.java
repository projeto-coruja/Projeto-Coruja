package Persistence.DTO.DTOCreator;

import Persistence.DTO.OrigemDTO;
import Persistence.Model.Origem;

public class OrigemDTOFactory implements DTOFactory {


	/**
	 * @see Persistence.DTO.DTOCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public OrigemDTO createDTO(Object entity) {
		OrigemDTO newDTO = new OrigemDTO();
		Origem entry = (Origem) entity;
		newDTO.setCodOrigem(entry.getCodOrigem());
		newDTO.setTipoOrigem(entry.getTipoOrigem());
		newDTO.setTitulo(entry.getTitulo());
		return newDTO;

	}

}
