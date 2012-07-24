package Persistence.EntityCreator;

import Persistence.DTO.DTO;
import Persistence.DTO.IdNumDocumentoDTO;
import Persistence.Model.IdNumDocumento;

public class IdNumDocumentoFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public IdNumDocumento createEntity(DTO dto) {
		IdNumDocumento newEnt = new IdNumDocumento();
		IdNumDocumentoDTO entry = (IdNumDocumentoDTO) dto;
		
		newEnt.setCodId(entry.getCodId());
		newEnt.setTipoId(entry.getTipoId());
		
		return newEnt;
	}

}
