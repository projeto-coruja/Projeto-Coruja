package persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import persistence.dto.DTO;
import persistence.dto.ProfileDTO;

public class Persistence {
	PersistenceAccess pa;
	DTO dto;
	
	@Before
	@Test
	public void persistenceAccess(){
		 pa = new PersistenceAccess();
		 assertNotNull(pa);
	}
	@Ignore
	@Test
	public void saveEntity() {
		dto = new ProfileDTO();
		
		((ProfileDTO) dto).setEdit(true);
		((ProfileDTO) dto).setRead(true);
		((ProfileDTO) dto).setWrite(true);
		((ProfileDTO) dto).setProfile("lalala");
		pa.saveEntity(((ProfileDTO) dto));
	}
	

	@Ignore
	@Test
	public void testFindEntities() {
		List<DTO> l = pa.findEntities("from Profile");
		assertEquals((ProfileDTO)dto,l.get(l.size()-1));
	}

	@Ignore
	@Test
	public void testPersistenceAccess() {
		assertNotNull(pa);
	}


	@Test
	public void testUpdateEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSingleEntity() {
		fail("Not yet implemented");
	}

}
