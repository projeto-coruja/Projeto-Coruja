package persistence.utility;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

public class PersistenceUtilityTest {

	@Test
	public void testOpenSession() {
		Session s = PersistenceUtility.openSession();
		assertNotNull(s);
	}

}
