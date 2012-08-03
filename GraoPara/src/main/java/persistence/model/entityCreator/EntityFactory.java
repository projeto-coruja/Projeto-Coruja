package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.model.Entidade;

public interface EntityFactory {

	public Entidade createEntity(DTO dto);
}
