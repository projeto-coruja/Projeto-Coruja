package util;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import control.DAO.genericCreate.HibernateUtil;


public class ConectTeste {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Session s = new HibernateUtil().getSession().openSession();
		assertTrue(s!=null);
	}

}
