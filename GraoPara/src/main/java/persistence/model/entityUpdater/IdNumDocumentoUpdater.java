package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.model.Entidade;
import persistence.model.IdNumDocumento;

public class IdNumDocumentoUpdater implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		IdNumDocumentoDTO entry = (IdNumDocumentoDTO) dto;
		
		((IdNumDocumento) ent).setId(entry.getId());
		((IdNumDocumento) ent).setTipoId(entry.getTipoId());
		((IdNumDocumento) ent).setCodId(entry.getCodId());
		
		return ent;
	}

}
