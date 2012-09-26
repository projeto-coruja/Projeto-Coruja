package persistence.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.jdto.DTOBinder;
import org.jdto.DTOBinderFactory;

import persistence.dto.DTO;
import persistence.dto.PalavraChave;
import persistence.model.PalavraChaveMO;
import persistence.model.TemaPalavraChaveMO;

@SuppressWarnings("rawtypes")
public class DTOUtility {
	
	private static final String dtoPrefix = "persistence.dto.";
	private static final String entityPrefix = "persistence.model.";
	
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
	
	public void updateEntityFromDTO(Object ent, DTO dto){
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
			for(Method set : ec_setters) {
				if(!get.getName().substring(3).equals("Id") && get.getName().substring(3).equals(set.getName().substring(3))) {
					try {
						set.invoke(ent_class, get.invoke(dto_class, (Object[]) null));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		PalavraChaveMO ent_pc = new PalavraChaveMO();
		TemaPalavraChaveMO tema_pc = new TemaPalavraChaveMO();
		tema_pc.setId(2L);
		tema_pc.setTema("Atores");
		ent_pc.setId(1L);
		ent_pc.setPalavra("Palavra");
		ent_pc.setTema(tema_pc);
		System.out.println(ent_pc.getId() + "-" + ent_pc.getPalavra() + "-" + ent_pc.getTema().toString());
		
		DTOBinder binder = DTOBinderFactory.getBinder();
		PalavraChave dto_pc = binder.bindFromBusinessObject(PalavraChave.class, ent_pc);
		dto_pc.setId(3L);
		System.out.println(dto_pc.getId() + "-" + dto_pc.getPalavra() + "-" + dto_pc.getTema().toString());
		
		DTOUtility hora = new DTOUtility();
		hora.updateEntityFromDTO(ent_pc, dto_pc);
		System.out.println(ent_pc.getId() + "-" + ent_pc.getPalavra() + "-" + ent_pc.getTema().toString());
		
	}

}
