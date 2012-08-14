package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.model.Entidade;
import persistence.model.TipoDocumento;

public class TipoDocumentoFactory implements EntityFactory {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade createEntity(DTO dto) {
		TipoDocumento newEnt = new TipoDocumento();
		TipoDocumentoDTO entry = (TipoDocumentoDTO) dto;

		newEnt.setTipoDocumento(entry.getTipoDocumento());
		
		return newEnt;
	}

}
