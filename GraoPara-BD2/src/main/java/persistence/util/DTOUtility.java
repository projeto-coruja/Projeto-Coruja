package persistence.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import persistence.dto.DTO;

/**
 * @
 * 
 * 
 * @author Hueho
 *
 */

@SuppressWarnings("rawtypes")
public class DTOUtility {
	
	private static final String dtoPrefix = "persistence.dto.";
	private static final String entityPrefix = "persistence.model.";
	
	/**
	 * Função utilitária para encontrar a classe de entidade correspondente ao DTO passado como<br>
	 * parâmetro. 
	 * @param DTO dto
	 * 
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
	
	@SuppressWarnings("unchecked")
	public void updateEntityFromDTO(Object ent, DTO dto) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		
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
						Object arg = get.invoke(dto, (Object[]) null);
						if(!(arg instanceof DTO))
							set.invoke(ent, arg);
						else {
							Method ent_getter = ent_class.getMethod(get.getName(), (Class[]) null);
							Object embedded_ent = ent_getter.invoke(ent, (Object[]) null);
							updateEntityFromDTO(embedded_ent, (DTO) arg);
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
	}

}
