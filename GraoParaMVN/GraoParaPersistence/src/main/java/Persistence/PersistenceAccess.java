package Persistence;

import java.util.List;

import Persistence.DTO.DTOCreator.DTOGenerator;
import Persistence.EntityCreator.EntityGenerator;
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

	public void saveEntity(Object dto) {
		sharedManager.save(entGen.generateEntity(dto));
	}

	public void updateEntity(Object dto) {
		sharedManager.update(entGen.generateEntity(dto));
	}

	public void deleteEntity(Object dto) {
		sharedManager.delete(entGen.generateEntity(dto));
	}
	
	@SuppressWarnings("rawtypes")
	public Object findSingleEntity(Class table, long id) {
		return dtoGen.generateDTOSet(sharedManager.find(table, id));
	}


	public List findEntities(String query) {
		return dtoGen.generateDTOSet(sharedManager.find(query));
	}

}
