package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.model.Entidade;
import persistence.model.TipoDocumento;

public class TipoDocumentoUpdater implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		TipoDocumentoDTO entry = (TipoDocumentoDTO) dto;
		

		((TipoDocumento) ent).setId(entry.getId());
		((TipoDocumento) ent).setTipoDocumento(entry.getTipoDocumento());
		
		return ent;
	}

}
