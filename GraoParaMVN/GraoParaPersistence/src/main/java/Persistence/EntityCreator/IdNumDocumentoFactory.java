package Persistence.EntityCreator;

import Persistence.DTO.IdNumDocumentoDTO;
import Persistence.Model.IdNumDocumento;

public class IdNumDocumentoFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public IdNumDocumento createEntity(Object dto) {
		IdNumDocumento newEnt = new IdNumDocumento();
		IdNumDocumentoDTO entry = (IdNumDocumentoDTO) dto;
		
		newEnt.setCodId(entry.getCodId());
		newEnt.setTipoId(entry.getTipoId());
		
		return newEnt;
	}

}
