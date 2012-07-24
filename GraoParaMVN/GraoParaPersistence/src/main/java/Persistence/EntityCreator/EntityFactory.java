package Persistence.EntityCreator;

import Persistence.DTO.DTO;
import Persistence.Model.Entidade;

public interface EntityFactory {

	public Entidade createEntity(DTO dto);

}
