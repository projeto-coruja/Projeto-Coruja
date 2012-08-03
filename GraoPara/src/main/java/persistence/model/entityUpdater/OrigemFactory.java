package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.OrigemDTO;
import persistence.model.Entidade;
import persistence.model.Origem;

public class OrigemFactory implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Origem updateEntity(DTO dto, Entidade ent) {
		Origem newEnt = new Origem();
		OrigemDTO entry = (OrigemDTO) dto;
		
		newEnt.setCodOrigem(entry.getCodOrigem());
		newEnt.setTipoOrigem(entry.getTipoOrigem());
		newEnt.setTitulo(entry.getTitulo());
		
		return newEnt;
	}

}
