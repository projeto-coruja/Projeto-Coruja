package persistence.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;
import persistence.model.EntityMO;

/**
 * Classe utilitária para ajudar na manutenção dos DTOs.<br>
 * Por padrão, programa-se principalmente por convenção. A única configuração opcional<br>
 * é feita a nível de código, definindo os pacotes onde estão armazenadas as classes<br>
 * de entidade e de DTO.
 */

@SuppressWarnings("rawtypes")
public class DTOUtility {
	
	private static final String dtoPrefix = "persistence.dto.";
	private static final String entityPrefix = "persistence.model.";
	
	/**
	 * Função utilitária para encontrar a classe de entidade correspondente a instância de<br>
	 * DTO passada como parâmetro. 
	 * @param dto a instância do DTO de onde queremos derivar a entidade
	 * @return o objeto Class representando a entidade desejada
	 */
	public Class findEntityClassForDTO(DTO dto){
		Class clazz = dto.getClass();
		String name = clazz.getSimpleName();
		try {
			return Class.forName(entityPrefix + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Função utilitária para encontrar a classe de DTO correspondente a instância de<br>
	 * entidade passada como parâmetro. 
	 * @param ent a instância de entidade de onde queremos derivar a DTO
	 * @return o objeto Class representando o DTO desejada
	 */
	public Class findDTOClassForEntity(Object ent){
		Class clazz = ent.getClass();
		String name = clazz.getSimpleName();
		try {
			return Class.forName(dtoPrefix + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	/** 
	 * Função que atualiza uma entidade com base em um DTO. A função utiliza reflexão para derivar dinamicamente<br>
	 * os getters e setters dos objetos, e então executá-los de acordo. Quando for necessário atualizar um campo<br>
	 * de entidade, a função é chamada recursivamente utilizando como parâmetros a entidade e o DTO embutidos.
	 * @param ent a instância de entidade
	 * @param dto a instância de DTO
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException 
	 */
	@SuppressWarnings("unchecked")
	public void updateEntityFromDTO(EntityMO ent, DTO dto) throws IllegalArgumentException, UpdateEntityException {
		
		if(ent == null) throw new IllegalArgumentException("Entity argument is null");
		if(dto == null) throw new IllegalArgumentException("DTO argument is null");
		
		Class ent_class = ent.getClass();
		Class dto_class = dto.getClass();
		
		Method[] ec_methods = ent_class.getDeclaredMethods();
		Method[] dc_methods = dto_class.getDeclaredMethods();
		
		ArrayList<Method> dc_getters = new ArrayList<Method>();
		ArrayList<Method> ec_setters = new ArrayList<Method>();
		
		for(Method m : dc_methods) {
			if(m.getName().startsWith("get"))
				dc_getters.add(m);
		}
		
		for(Method n : ec_methods) {
			if(n.getName().startsWith("set"))
				ec_setters.add(n);
		}
		
		for(Method get : dc_getters) {
			if(!get.getName().substring(3).equals("Id")){
				for(Method set : ec_setters) {
					if(get.getName().substring(3).equals(set.getName().substring(3))) {
						Object arg;
						try {
							arg = get.invoke(dto, (Object[]) null);
							if(!(arg instanceof DTO))
								set.invoke(ent, arg);
							else {
								Method ent_getter = ent_class.getMethod(get.getName(), (Class[]) null);
								EntityMO embedded_ent = (EntityMO) ent_getter.invoke(ent, (Object[]) null);
								updateEntityFromDTO(embedded_ent, (DTO) arg);
							}
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							throw new UpdateEntityException("Erro ao atualizar entidade.");
						} catch (InvocationTargetException e) {
							e.printStackTrace();
							throw new UpdateEntityException("Erro ao atualizar entidade.");
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
							throw new UpdateEntityException("Erro ao atualizar entidade.");
						} catch (SecurityException e) {
							e.printStackTrace();
							throw new UpdateEntityException("Erro ao atualizar entidade.");
						}
					}
				}
			}
		}
	}

}
