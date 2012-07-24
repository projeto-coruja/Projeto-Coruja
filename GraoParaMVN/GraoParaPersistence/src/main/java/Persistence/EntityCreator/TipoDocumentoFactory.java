package Persistence.EntityCreator;

import Persistence.DTO.DTO;
import Persistence.DTO.TipoDocumentoDTO;
import Persistence.Model.Entidade;
import Persistence.Model.TipoDocumento;

public class TipoDocumentoFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade createEntity(DTO dto) {
		TipoDocumento newEnt = new TipoDocumento();
		TipoDocumentoDTO entry = (TipoDocumentoDTO) dto;
		
		newEnt.setTipoDocumento(entry.getTipoDocumento());
		
		return newEnt;
	}

}
