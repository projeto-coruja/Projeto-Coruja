package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.model.Entidade;

public interface EntityUpdate {

	public Entidade updateEntity(DTO dto, Entidade ent);
}
