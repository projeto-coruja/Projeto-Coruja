import static org.junit.Assert.*;
import login.Profile;
import login.User;

import org.hibernate.Session;
import org.junit.Test;

import control.DAO.HibernateUtil;
import control.DAO.LoginDAO;

public class Testes {

	@Test
	public void testGetSession() {
		Session sessao = HibernateUtil.getSession().openSession();
		assertTrue(sessao != null);
	}

	@Test
	public void loginDAO(){
		LoginDAO l = new LoginDAO();
		assertTrue(l != null);
	}
	
	@Test
	public void profileDAO(){
		Profile p = new Profile();
		p.setProfile("teste");
		p.setWrite(true);
		p.setRead(true);
		p.setEdit(true);
		LoginDAO l = new LoginDAO();
		l.createUser(p);
	}
}
