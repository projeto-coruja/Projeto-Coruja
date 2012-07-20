package Persistence.EntityCreator;

import Persistence.DTO.TipoDocumentoDTO;
import Persistence.Model.TipoDocumento;

public class TipoDocumentoFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public Object createEntity(Object dto) {
		TipoDocumento newEnt = new TipoDocumento();
		TipoDocumentoDTO entry = (TipoDocumentoDTO) dto;
		
		newEnt.setTipoDocumento(entry.getTipoDocumento());
		
		return newEnt;
	}

}
