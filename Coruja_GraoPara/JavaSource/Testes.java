import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import control.DAO.genericCreate.HibernateUtil;



public class Testes {

	@Test
	public void testGetSession() {
		Session sessao = HibernateUtil.getSession().openSession();
		assertTrue(sessao != null);
	}

}
