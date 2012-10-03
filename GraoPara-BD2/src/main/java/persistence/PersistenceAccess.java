package persistence;

import java.util.List;

import org.jdto.DTOBinder;
import org.jdto.DTOBinderFactory;

import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;
import persistence.model.EntityModel;
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
	
	@SuppressWarnings({"unchecked"})
	public DTO saveEntity(DTO dto) {
		EntityModel ent = (EntityModel) binder.extractFromDto(du.findEntityClassForDTO(dto), dto);
		em.save(ent);
		dto.setId(ent.getId());
		return dto;
	}
	
	public void updateEntity(DTO dto) throws IllegalArgumentException, UpdateEntityException {
		EntityModel entity = (EntityModel) em.find(du.findEntityClassForDTO(dto), dto.getId());
		du.updateEntityFromDTO(entity, dto);
		em.update(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<DTO> findEntity(String query) {
		List<Object> resultSet = em.find(query);
		if(resultSet == null || resultSet.size() <= 0){
			em.finishOperation();
			return null;
		}
		else{
			List<DTO> dtoSet = binder.bindFromBusinessObjectList(du.findDTOClassForEntity(resultSet.get(0)), resultSet);
			em.finishOperation();
			resultSet = null;
			return dtoSet;
		}
	}
	
	public void deleteEntity(DTO dto) {
		EntityModel dead = (EntityModel) em.find(du.findEntityClassForDTO(dto), dto.getId());
		em.delete(dead);
	}

	public Long countRows(String table, String criteria){
		if(table == null)	
			throw new IllegalArgumentException("Tabela não pode ser null");

		if(criteria == null)	
			return em.count(table, "1=1");
		else return em.count(table, criteria);
	}

}
