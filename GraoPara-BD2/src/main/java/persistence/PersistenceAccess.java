package persistence;

import org.jdto.DTOBinder;
import org.jdto.DTOBinderFactory;

import persistence.dto.DTO;
import persistence.util.DTOUtility;
import persistence.util.EntityManager;

public class PersistenceAccess {
	
	private static DTOBinder binder = DTOBinderFactory.getBinder();
	
	private EntityManager em;
	
	private DTOUtility du;
	
	public PersistenceAccess() {
		em = new EntityManager();
		du = new DTOUtility();
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void saveEntity(DTO dto) {
		em.save(binder.extractFromDto(du.findEntityClassForDTO(dto), dto));
	}
	
	public void updateEntity(DTO dto) {
		Object entity = em.find(du.findEntityClassForDTO(dto), dto.getId());
		
	}

}
