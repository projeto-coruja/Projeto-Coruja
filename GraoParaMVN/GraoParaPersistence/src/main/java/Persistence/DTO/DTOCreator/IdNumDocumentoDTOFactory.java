package Persistence.DTO.DTOCreator;

import Persistence.DTO.IdNumDocumentoDTO;
import Persistence.Model.Entidade;
import Persistence.Model.IdNumDocumento;

public class IdNumDocumentoDTOFactory implements DTOFactory {


	/**
	 * @see Persistence.DTO.DTOCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public IdNumDocumentoDTO createDTO(Entidade entity) {
		IdNumDocumentoDTO newDTO = new IdNumDocumentoDTO();
		IdNumDocumento entry = (IdNumDocumento) entity;
		
		newDTO.setCodId(entry.getCodId());
		newDTO.setTipoId(entry.getTipoId());
		
		return newDTO;
	}

}
