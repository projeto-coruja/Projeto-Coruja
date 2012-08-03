package persistence.dto.dtoCreator;

import persistence.dto.OrigemDTO;
import persistence.model.Entidade;
import persistence.model.Origem;

public class OrigemDTOFactory implements DTOFactory {


	/**
	 * @see persistence.dto.dtoCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public OrigemDTO createDTO(Entidade entity) {
		OrigemDTO newDTO = new OrigemDTO();
		Origem entry = (Origem) entity;
		newDTO.setId(entry.getId());
		newDTO.setCodOrigem(entry.getCodOrigem());
		newDTO.setTipoOrigem(entry.getTipoOrigem());
		newDTO.setTitulo(entry.getTitulo());
		return newDTO;

	}

}
