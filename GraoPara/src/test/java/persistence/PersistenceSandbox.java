package persistence;

import java.util.List;

import persistence.model.Documento;
import persistence.model.Entidade;
import persistence.utility.EntityManager;

public class PersistenceSandbox {
	
	public static void main(String[] args) {
		
		EntityManager em = new EntityManager();
		List<Entidade> l = em.find("from Documento where YEAR(dataDocumento) = 1655");
		if(l != null) { 
			Documento d = (Documento) l.get(0);
			System.out.println(d.getAutor());
		}
	}
}
