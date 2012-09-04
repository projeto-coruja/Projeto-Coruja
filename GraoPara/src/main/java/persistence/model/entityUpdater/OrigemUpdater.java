package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.OrigemDTO;
import persistence.model.Entidade;
import persistence.model.Origem;

public class OrigemUpdater implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		OrigemDTO entry = (OrigemDTO) dto;
		
		if(ent == null)	ent = new Origem();

		((Origem) ent).setId(entry.getId());
		((Origem) ent).setCodOrigem(entry.getCodOrigem());
		((Origem) ent).setTipoOrigem(entry.getTipoOrigem());
		((Origem) ent).setTitulo(entry.getTitulo());
		
		return ent;
	}

}
