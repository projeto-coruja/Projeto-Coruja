package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;
import persistence.model.PalavraChave;

public class PalavraChaveFactory implements EntityFactory {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public PalavraChave createEntity(DTO dto) {
		PalavraChave newEnt = new PalavraChave();
		PalavraChaveDTO entry = (PalavraChaveDTO) dto;

		newEnt.setPalavra(entry.getPalavra());
		newEnt.setAprovada(entry.isAprovada());
		
		return newEnt;
	}

}
