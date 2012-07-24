package Persistence.EntityCreator;

import Persistence.DTO.DTO;
import Persistence.DTO.OrigemDTO;
import Persistence.Model.Origem;

public class OrigemFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
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
