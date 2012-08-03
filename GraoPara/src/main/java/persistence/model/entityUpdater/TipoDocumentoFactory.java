package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.model.Entidade;
import persistence.model.TipoDocumento;

public class TipoDocumentoFactory implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		TipoDocumento newEnt = new TipoDocumento();
		TipoDocumentoDTO entry = (TipoDocumentoDTO) dto;
		
		newEnt.setTipoDocumento(entry.getTipoDocumento());
		
		return newEnt;
	}

}
