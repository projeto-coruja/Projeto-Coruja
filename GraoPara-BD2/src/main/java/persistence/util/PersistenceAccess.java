package persistence.util;

import java.util.List;

import org.jdto.DTOBinder;
import org.jdto.DTOBinderFactory;

import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;
import persistence.model.EntityModel;

public class PersistenceAccess {
	
	private EntityManager man;
	
	private DTOBinder binder;
	
	private DTOUtility du;
	
	public PersistenceAccess() {
		man = new EntityManager();
		binder = DTOBinderFactory.getBinder();
		du = new DTOUtility();
	}
	
	public void saveEntity(DTO dto) throws IllegalArgumentException, UpdateEntityException, InstantiationException, IllegalAccessException {
		EntityModel em = du.createEmptyEntityInstanceFromDTOType(dto);
		du.updateEntityFromDTO(em, dto);
		man.save(em);
		dto.setId(em.getId());
	}
	
	public void updateEntity(DTO dto) throws IllegalArgumentException, UpdateEntityException {
		EntityModel entity = man.find(du.findEntityClassForDTO(dto), dto.getId());
		if(entity == null) throw new IllegalArgumentException("NÃO MEXA NO ID DE DTOs!");
		du.updateEntityFromDTO((EntityModel) entity, dto);
		man.update(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<DTO> findEntity(String query) {
		List<Object> resultSet = man.find(query);
		if(resultSet == null || resultSet.isEmpty()) return null;
		else{
			List<DTO> dtoSet = binder.bindFromBusinessObjectList(du.findDTOClassForEntity(resultSet.get(0)), resultSet);
			resultSet = null;
			return dtoSet;
		}
	}
	
	public void deleteEntity(DTO dto) {
		Object dead = man.find(du.findEntityClassForDTO(dto), dto.getId());
		man.delete((EntityModel) dead);
	}

}
