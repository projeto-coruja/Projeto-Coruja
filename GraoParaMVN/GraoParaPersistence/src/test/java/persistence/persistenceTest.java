package persistence;

import org.testng.annotations.Test;

import persistence.dto.ProfileDTO;

public class persistenceTest {
	
	public PersistenceAccess PA;
	
	public void setUp() {
		PersistenceAccess PA = new PersistenceAccess();
	}
	
	@Test
	public void f() {
		
		ProfileDTO p = new ProfileDTO();
		p.setEdit(true);
		p.setRead(true);
		p.setWrite(true);
		p.setProfile("teste_teste");
		PA.saveEntity(p);
	}
}

