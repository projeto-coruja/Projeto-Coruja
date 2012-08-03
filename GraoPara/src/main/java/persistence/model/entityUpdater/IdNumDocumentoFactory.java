package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.model.Entidade;
import persistence.model.IdNumDocumento;

public class IdNumDocumentoFactory implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public IdNumDocumento updateEntity(DTO dto, Entidade ent) {
		IdNumDocumento newEnt = new IdNumDocumento();
		IdNumDocumentoDTO entry = (IdNumDocumentoDTO) dto;
		
		newEnt.setCodId(entry.getCodId());
		newEnt.setTipoId(entry.getTipoId());
		
		return newEnt;
	}

}
