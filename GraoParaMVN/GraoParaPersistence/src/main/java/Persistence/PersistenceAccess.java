package Persistence;

import java.util.List;

import org.hibernate.HibernateException;
import Persistence.DTO.DTOCreator.DTOGenerator;
import Persistence.EntityCreator.EntityGenerator;
import Persistence.Utility.EntityManager;
import Persistence.Utility.PersistenceUtility;

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

	public void updateEntity(Object dto) {

	}

	public void deleteEntity(Object dto) {

	}
	
	@SuppressWarnings("rawtypes")
	public Object findSingleEntity(Class table, long id) {
		return dtoGen.generateDTOSet(sharedManager.find(table, id));
	}


	public List findEntities(String query) {
		return dtoGen.generateDTOSet(sharedManager.find(query));
	}

}
