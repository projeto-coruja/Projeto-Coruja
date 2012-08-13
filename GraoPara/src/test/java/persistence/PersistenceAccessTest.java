package persistence;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;

public class PersistenceAccessTest {

	PersistenceAccess pa;
	DTO profile;
	DTO user;
	DTO user2;
	
	@Before
	public void setUp(){
		pa = new PersistenceAccess();
		profile = new ProfileDTO("lalala", true, true, true);
		user = new UserDTO("Hueho", "senha", (ProfileDTO) profile, "hueho@coruja.org", new Date());
		user2 = new UserDTO("Kawai", "123", (ProfileDTO) profile, "kawai@coruja.org", new Date());
	}
	
	@Test
	public void persistenceAccess(){
		 assertNotNull(pa);
	}
	
	@Ignore
	@Test
	public void saveEntity() {
		pa.saveEntity(profile);
		pa.saveEntity(user);
		pa.saveEntity(user2);
	}
	

	@Ignore
	@Test
	public void testFindEntities() {
		List<DTO> l = pa.findEntities("from Profile");
		ProfileDTO q = (ProfileDTO) l.get(l.size() - 1);
		assertEquals(((ProfileDTO) profile).getProfile(), q.getProfile());
	}
	
	@Ignore
	@Test
	public void testUpdateEntity() {
		List<DTO> l = pa.findEntities("from User");
		UserDTO t_user = (UserDTO) l.get(l.size() - 1);
		
		ProfileDTO t_profile = (ProfileDTO) t_user.getUserProfile();
		
		t_profile.setEdit(false);
		t_profile.setWrite(false);
		t_profile.setRead(false);
		t_profile.setProfile("alalalala");
		pa.updateEntity(t_profile);
		pa.updateEntity(t_user);
		
		l = pa.findEntities("from User");
		t_user = (UserDTO) l.get(l.size() - 1);
		t_profile = t_user.getUserProfile();
		assertEquals(t_profile.getProfile(), "alalalala");
	}
	
	@Ignore
	@Test
	public void testDeleteEntity() {
		List<DTO> l = pa.findEntities("from User");
		for(DTO t : l)
			pa.deleteEntity(t);
		l = pa.findEntities("from User");
		assertTrue(l == null);
	}

}
