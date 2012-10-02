package persistence.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;
import persistence.model.EntityModel;

/**
 * Classe utilitária para ajudar na manutenção dos DTOs.<br>
 * Versão sem Spring funciona por convenção
 */

@SuppressWarnings("rawtypes")
public class DTOUtility {
	
	private final String dtoPrefix = "persistence.dto";
	private final String entityPrefix = "persistence.model";
	private final String dtoSuffix = "";
	private final String entitySuffix = "MO";
	
	
	private EntityManager em;
	
	public DTOUtility(){
		
		em = new EntityManager();

	}
	
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
			return Class.forName(entityPrefix + "." + name + entitySuffix);
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
		String name = clazz.getSimpleName().replace(entitySuffix, dtoSuffix);
		try {
			return Class.forName(dtoPrefix + "." + name);
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
	public void updateEntityFromDTO(EntityModel ent, DTO dto) throws IllegalArgumentException, UpdateEntityException {
		
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
						Object arg = null;
						try {
							arg = get.invoke(dto, (Object[]) null);
							if(arg == null) {
								set.invoke(ent, arg);
							}
							if(arg instanceof List){
								Object test_type = ((List) arg).get(0);
								if(test_type instanceof DTO) {
									/*
									 * arg é uma lista
									 * se executar o get na entidade também será uma lista 
									 */
									Method ent_list_getter = ent_class.getMethod(get.getName(), (Class[]) null);
									List<EntityModel> ent_list = (List<EntityModel>) ent_list_getter.invoke(ent, (Object[]) null);
									List<DTO> dto_list = (List<DTO>) arg;
									boolean check = true;
									/*
									 * para cada DTO, itera pelas entidades que já existirem
									 * se o DTO não possuir id em comum com qualquer entidade, busque
									 * a entidade relacionada ao DTO do banco de dados. Se não existir, 
									 * taca exceção porque setaram o Id do DTO manualmente
									 */
									if(ent_list != null) {
										for(DTO dto_e : dto_list) {
											if(dto_e.getId() != null) {
												for(EntityModel ent_e : ent_list) {
													if(dto_e.getId() == ent_e.getId()) {
														check = false;
														break;
													}
												}
												if(check) {
													EntityModel new_ent = (EntityModel) em.find(findEntityClassForDTO(dto_e), dto_e.getId());
													if(new_ent != null) {
														ent_list.add(new_ent);
													}
													else {
														throw new UpdateEntityException("DO NOT SET ID ON NEWLY CREATED DTO INSTANCES");
													}
												}
											}
											else {
												EntityModel new_ent = createEmptyEntityInstanceFromDTOType(dto_e);
												updateEntityFromDTO(new_ent, dto_e);
												em.save(new_ent);
												ent_list.add(new_ent);
											}
										}
									}
									else {
										ent_list = new ArrayList<EntityModel>();
										for(DTO dto_e : dto_list) {
											if(dto_e.getId() != null) {
												EntityModel new_ent = (EntityModel) em.find(findEntityClassForDTO(dto_e), dto_e.getId());
												if(new_ent != null) {
													ent_list.add(new_ent);
												}
												else {
													throw new UpdateEntityException("DO NOT SET ID ON NEWLY CREATED DTO INSTANCES");
												}
											}
											else {
												EntityModel new_ent = createEmptyEntityInstanceFromDTOType(dto_e);
												updateEntityFromDTO(new_ent, dto_e);
												em.save(new_ent);
												ent_list.add(new_ent);
											}
										}
									}
									set.invoke(ent, ent_list);
								}
								else {
									List<Object> ent_list = new ArrayList<Object>();
									for(Object obj : (List<Object>) arg) {
										ent_list.add(obj);
									}
									set.invoke(ent, ent_list);
								}
							}
							else if(arg instanceof DTO){
								Method ent_getter = ent_class.getMethod(get.getName(), (Class[]) null);
								Object embedded_ent = ent_getter.invoke(ent, (Object[]) null);
								if(embedded_ent == null) {
									if(((DTO) arg).getId() == null){
										Class embedded_ent_class = ent_getter.getReturnType();
										embedded_ent = embedded_ent_class.newInstance();
										updateEntityFromDTO((EntityModel) embedded_ent, (DTO) arg);
										em.save((EntityModel) embedded_ent);
										set.invoke(ent, embedded_ent);
									}
									else{
										embedded_ent = em.find(findEntityClassForDTO((DTO) arg), ((DTO) arg).getId());
										if(embedded_ent != null) {
											updateEntityFromDTO((EntityModel) embedded_ent, (DTO) arg);
											em.update((EntityModel) embedded_ent);
											set.invoke(ent, embedded_ent);
										}
										else {
											throw new UpdateEntityException("DO NOT SET ID ON NEWLY CREATED DTO INSTANCES");
										}
									}
								}
							} else set.invoke(ent, arg);
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
						} catch (InstantiationException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public EntityModel createEmptyEntityInstanceFromDTOType(DTO dto) throws InstantiationException, IllegalAccessException {
		return (EntityModel) findEntityClassForDTO(dto).newInstance();
	}

}
