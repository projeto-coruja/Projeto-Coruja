package persistence.dto.dtoCreator;

import persistence.dto.IdNumDocumentoDTO;
import persistence.model.Entidade;
import persistence.model.IdNumDocumento;

public class IdNumDocumentoDTOFactory implements DTOFactory {


	/**
	 * @see persistence.dto.dtoCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public IdNumDocumentoDTO createDTO(Entidade entity) {
		IdNumDocumentoDTO newDTO = new IdNumDocumentoDTO();
		IdNumDocumento entry = (IdNumDocumento) entity;
		
		newDTO.setId(entry.getId());
		newDTO.setCodId(entry.getCodId());
		newDTO.setTipoId(entry.getTipoId());
		
		return newDTO;
	}

}
