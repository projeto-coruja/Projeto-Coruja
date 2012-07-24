package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;
import persistence.model.Entidade;
import persistence.model.PalavraChave;

public class PalavraChaveFactory implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public PalavraChave updateEntity(DTO dto, Entidade ent) {
		PalavraChave newEnt = new PalavraChave();
		PalavraChaveDTO entry = (PalavraChaveDTO) dto;
		
		newEnt.setPalavra(entry.getPalavra());
		newEnt.setAprovada(entry.isAprovada());
		
		return newEnt;
	}

}
