package persistence.dto.dtoCreator;

import persistence.dto.DTO;
import persistence.model.Entidade;

public interface DTOFactory {

	public DTO createDTO(Entidade entity);

}
