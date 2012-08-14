package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.model.IdNumDocumento;

public class IdNumDocumentoFactory implements EntityFactory {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public IdNumDocumento createEntity(DTO dto) {
		IdNumDocumento newEnt = new IdNumDocumento();
		IdNumDocumentoDTO entry = (IdNumDocumentoDTO) dto;

		newEnt.setCodId(entry.getCodId());
		newEnt.setTipoId(entry.getTipoId());
		
		return newEnt;
	}

}
