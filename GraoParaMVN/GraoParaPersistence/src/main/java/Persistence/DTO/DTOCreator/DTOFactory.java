package Persistence.DTO.DTOCreator;

import Persistence.DTO.DTO;
import Persistence.Model.Entidade;

public interface DTOFactory {

	public DTO createDTO(Entidade entity);

}
