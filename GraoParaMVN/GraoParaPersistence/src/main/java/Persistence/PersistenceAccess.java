package Persistence;

import java.util.List;

import Persistence.DTO.DTO;
import Persistence.DTO.DTOCreator.DTOGenerator;
import Persistence.EntityCreator.EntityGenerator;
import Persistence.Model.Entidade;
import Persistence.Utility.EntityManager;

public class PersistenceAccess {

	private DTOGenerator dtoGen;

	private EntityGenerator entGen;

	private EntityManager sharedManager;
	
	public PersistenceAccess() {
		dtoGen = new DTOGenerator();
		entGen = new EntityGenerator();
		sharedManager = new EntityManager();
	}

	public void saveEntity(DTO dto) {
		sharedManager.save((Entidade) entGen.generateEntity(dto));
	}

	public void updateEntity(DTO dto) {
		sharedManager.update((Entidade) entGen.generateEntity(dto));
	}

	public void deleteEntity(DTO dto) {
		sharedManager.delete((Entidade) entGen.generateEntity(dto));
	}
	
	@SuppressWarnings({ "rawtypes" })
	public DTO findSingleEntity(Class table, long id) {
		return dtoGen.generateDTOSet(sharedManager.find(table, id));
	}


	public List<DTO> findEntities(String query) {
		return dtoGen.generateDTOSet(sharedManager.find(query));
	}

}
