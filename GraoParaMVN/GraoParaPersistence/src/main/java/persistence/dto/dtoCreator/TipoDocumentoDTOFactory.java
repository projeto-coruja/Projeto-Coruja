package persistence.dto.dtoCreator;

import persistence.dto.TipoDocumentoDTO;
import persistence.model.Entidade;
import persistence.model.TipoDocumento;


public class TipoDocumentoDTOFactory implements DTOFactory {


	/**
	 * @see persistence.dto.dtoCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public TipoDocumentoDTO createDTO(Entidade entity) {
		TipoDocumentoDTO newDTO = new TipoDocumentoDTO();
		TipoDocumento entry = (TipoDocumento) entity;
		newDTO.setId(entry.getId());
		newDTO.setTipoDocumento(entry.getTipoDocumento());
		
		return newDTO;

	}

}
