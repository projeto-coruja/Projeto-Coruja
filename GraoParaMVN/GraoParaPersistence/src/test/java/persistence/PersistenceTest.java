package persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.model.Profile;

public class PersistenceTest {
	
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
	
	@Ignore
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
	
	//@Ignore
	@Test
	public void testDeleteEntity() {
		List<DTO> l = pa.findEntities("from Profile");
		ProfileDTO t = (ProfileDTO) l.get(l.size() - 1);
		pa.deleteEntity(t);
		l = pa.findEntities("from Profile");
		assertTrue(l == null);
	}
}
