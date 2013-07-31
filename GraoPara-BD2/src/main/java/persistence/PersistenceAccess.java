package persistence;

import java.util.List;

import org.jdto.DTOBinder;
import org.jdto.DTOBinderFactory;

import persistence.dto.DTO;
import persistence.model.EntityModel;
import persistence.util.DTOUtility;
import persistence.util.EntityManager;

/**
 * Façade que receberá as requisições do business.
 */
public class PersistenceAccess {
	
	private EntityManager man;
	
	private DTOBinder binder;
	
	private DTOUtility du;
	
	/**
	 * 
	 */
	public PersistenceAccess() {
		man = new EntityManager();
		binder = DTOBinderFactory.getBinder();
		du = new DTOUtility();
	}
	
	/**
	 * Salva um objeto no banco de dados.
	 * @param dto - DTO do objeto a ser salvo.
	 * @throws IllegalArgumentException - dto ser nulo ou haver alguma inconsistência no objeto passado.
	 */
	public void saveEntity(DTO dto) throws IllegalArgumentException {
		EntityModel em = du.createEmptyEntityInstanceFromDTOType(dto);
		du.updateEntityFromDTO(em, dto);
		man.save(em);
		dto.setId(em.getId());
	}
	
	/**
	 * Atualiza um objeto no banco de dados.
	 * @param dto - DTO do objeto a ser atualizado.
	 * @throws IllegalArgumentException - dto ser nulo ou haver alguma inconsistência no objeto passado.
	 */
	public void updateEntity(DTO dto) throws IllegalArgumentException {
		EntityModel entity = man.find(du.findEntityClassForDTO(dto), dto.getId());
		if(entity == null) throw new IllegalArgumentException("NÃO MEXA NO ID DE DTOs!");
		du.updateEntityFromDTO((EntityModel) entity, dto);
		man.update(entity);
	}
	
	/**
	 * Busca um objeto no banco de dados utilizando query sql.
	 * @param query
	 * @return	List&lt;DTO&gt; contendo o resultado.
	 */
	@SuppressWarnings("unchecked")
	public List<DTO> findEntity(String query) {
		List<Object> resultSet = man.find(query);
		if(resultSet == null || resultSet.isEmpty()) {
			man.finishOperation();
			return null;
		}
		else{
			List<DTO> dtoSet = binder.bindFromBusinessObjectList(du.findDTOClassForEntity(resultSet.get(0)), resultSet);
			man.finishOperation();
			resultSet = null;
			return dtoSet;
		}
	}
	
	/**
	 * Deleta um objeto do banco de dados.
	 * @param dto - Objeto a ser removido.
	 */
	public void deleteEntity(DTO dto) {
		Object dead = man.find(du.findEntityClassForDTO(dto), dto.getId());
		man.delete((EntityModel) dead);
	}
	
	/**
	 * Pega o número de entradas de uma tabela.
	 * @param name - Nome da tabela.
	 * @param criteria - Critério da conta (i.e. idade >= 40). Usar '1=1' para retornar o número de todas as entradas.
	 * @return <i>Long</i> contendo o número de entradas.
	 */
	public Long countRows(String name, String criteria) {
		return man.count(du.findEntityNameForDTOName(name), criteria);
	}

}
