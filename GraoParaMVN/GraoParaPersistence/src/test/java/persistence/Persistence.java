package persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.model.Profile;

public class Persistence {
	
	PersistenceAccess pa;
	DTO dto;
	
	@Before
	public void setUp(){
		pa = new PersistenceAccess();
		dto = new ProfileDTO();
		
		((ProfileDTO) dto).setEdit(true);
		((ProfileDTO) dto).setRead(true);
		((ProfileDTO) dto).setWrite(true);
		((ProfileDTO) dto).setProfile("lalala");
	}
	
	@Test
	public void persistenceAccess(){
		 assertNotNull(pa);
	}
	
	@Ignore
	@Test
	public void saveEntity() {
		pa.saveEntity(((ProfileDTO) dto));
	}
	

	@Ignore
	@Test
	public void testFindEntities() {
		List<DTO> l = pa.findEntities("from Profile");
		ProfileDTO q = (ProfileDTO) l.get(l.size() - 1);
		assertEquals(((ProfileDTO) q).getProfile(), q.getProfile());
	}

	@Test
	public void testUpdateEntity() {
		List<DTO> l = pa.findEntities("from Profile");
		ProfileDTO r = (ProfileDTO) l.get(l.size() - 1);
		
		r.setEdit(false);
		r.setWrite(false);
		r.setRead(false);
		r.setProfile("alalalala");
		pa.updateEntity(r);
		
		ProfileDTO s = (ProfileDTO) pa.findSingleEntity(Profile.class, r.getId());
		assertEquals(r.getProfile(), s.getProfile());
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
