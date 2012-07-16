import static org.junit.Assert.*;

import java.util.List;

import login.Profile;
import login.User;

import org.hibernate.Session;
import org.junit.Test;

import control.DAO.AbstractDao;
import control.DAO.HibernateUtil;
import control.DAO.LoginDAO;

public class Testes {

	@Test
	public void testGetSession() {
		Session sessao = HibernateUtil.getSession().openSession();
		assertTrue(sessao != null);
	}

	
//	@Test
//	public void profileDAO(){
//		LoginDAO l = new LoginDAO();
//		
//		Profile p = new Profile();
//		p.setProfile("teste");
//		p.setWrite(true);
//		p.setRead(true);
//		p.setEdit(true);
//		
//		User u = new User();
//		u.setUsername("teste");
//		u.setPassword("lalala");
//		u.setName("um nome");
//		u.setEmail("emaillegal@superfoda.com");
//		u.setUserProfile(p);
//		
//		l.saveProfile(p);
//		l.saveUser(u);
//		
//		u.setName("Outro Nome");
//		
//		l.updateUser(u);
//	}
	
	@Test
	public void findAll(){
		LoginDAO dao = new LoginDAO();
		List<User> l = dao.findAllUsers();
		System.out.println(l.size());
		User u = l.get(0);
		assertTrue(u.getName().equals("Outro Nome"));
		assertTrue(u.getUsername().equals("teste"));
	}
}
