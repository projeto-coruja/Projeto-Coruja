package test;

import org.jdto.DTOBinder;
import org.jdto.DTOBinderFactory;

import persistence.util.EntityManager;

@SuppressWarnings("unused")
public class Sandbox {

	private static EntityManager em;
	private static DTOBinder binder;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		binder = DTOBinderFactory.getBinder();
		em = new EntityManager();
	}

}
