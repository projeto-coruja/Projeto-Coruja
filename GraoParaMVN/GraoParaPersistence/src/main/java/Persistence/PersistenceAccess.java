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
		
	}

	public void updateEntity() {

	}

	public void deleteEntity() {

	}

	public List retriveEntities() {
		return null;
	}

}
