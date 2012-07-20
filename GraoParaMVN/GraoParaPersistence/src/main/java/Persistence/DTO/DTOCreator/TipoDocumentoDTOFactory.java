package Persistence.DTO.DTOCreator;

import Persistence.DTO.TipoDocumentoDTO;
import Persistence.Model.TipoDocumento;


public class TipoDocumentoDTOFactory implements DTOFactory {


	/**
	 * @see Persistence.DTO.DTOCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public TipoDocumentoDTO createDTO(Object entity) {
		TipoDocumentoDTO newDTO = new TipoDocumentoDTO();
		TipoDocumento entry = (TipoDocumento) entity;
		newDTO.setTipoDocumento(entry.getTipoDocumento());
		
		return newDTO;

	}

}
