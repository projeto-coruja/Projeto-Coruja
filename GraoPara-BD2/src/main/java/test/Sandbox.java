package test;

import java.lang.reflect.InvocationTargetException;

import org.jdto.DTOBinder;
import org.jdto.DTOBinderFactory;

import persistence.dto.PalavraChave;
import persistence.dto.TemaPalavraChave;
import persistence.model.PalavraChaveMO;
import persistence.model.TemaPalavraChaveMO;
import persistence.util.DTOUtility;
import persistence.util.EntityManager;

@SuppressWarnings("unused")
public class Sandbox {

	private static EntityManager em;
	private static DTOBinder binder;

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
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
		dto_pc.setPalavra("Coisa");
		TemaPalavraChave tema_pc_2 = new TemaPalavraChave();
		tema_pc_2.setId(4L);
		tema_pc_2.setTema("Ação");
		dto_pc.setTema(tema_pc_2);
		System.out.println(dto_pc.getId() + "-" + dto_pc.getPalavra() + "-" + dto_pc.getTema().getTema());
		
		DTOUtility hora = new DTOUtility();
		hora.updateEntityFromDTO(ent_pc, dto_pc);
		System.out.println(ent_pc.getId() + "-" + ent_pc.getPalavra() + "-" + ent_pc.getTema().getTema());
		em = new EntityManager();
	}

}
