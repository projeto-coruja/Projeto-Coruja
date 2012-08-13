package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;
import persistence.model.Entidade;
import persistence.model.PalavraChave;

public class PalavraChaveUpdater implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		PalavraChaveDTO entry = (PalavraChaveDTO) dto;
		

		((PalavraChave) ent).setId(entry.getId());
		((PalavraChave) ent).setPalavra(entry.getPalavra());
		((PalavraChave) ent).setAprovada(entry.isAprovada());
		
		return ent;
	}

}
