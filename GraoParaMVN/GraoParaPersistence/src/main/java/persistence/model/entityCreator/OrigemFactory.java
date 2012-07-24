package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.dto.OrigemDTO;
import persistence.model.Origem;

public class OrigemFactory implements EntityFactory {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Origem createEntity(DTO dto) {
		Origem newEnt = new Origem();
		OrigemDTO entry = (OrigemDTO) dto;
		
		newEnt.setCodOrigem(entry.getCodOrigem());
		newEnt.setTipoOrigem(entry.getTipoOrigem());
		newEnt.setTitulo(entry.getTitulo());
		
		return newEnt;
	}

}
