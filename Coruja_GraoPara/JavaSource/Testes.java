import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;


public class Testes {

	@Test
	public void testGetSession() {
		Session sessao = new HibernateUtil().getSession().openSession();
		assertTrue(sessao != null);
	}

}
