package Persistence.EntityCreator;

import Persistence.DTO.DTO;
import Persistence.DTO.PalavraChaveDTO;
import Persistence.Model.PalavraChave;

public class PalavraChaveFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public PalavraChave createEntity(DTO dto) {
		PalavraChave newEnt = new PalavraChave();
		PalavraChaveDTO entry = (PalavraChaveDTO) dto;
		
		newEnt.setPalavra(entry.getPalavra());
		newEnt.setAprovada(entry.isAprovada());
		
		return newEnt;
	}

}
