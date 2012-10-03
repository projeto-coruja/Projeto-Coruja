package business.DAO.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public class LoginDAOTest {
	
	@Before
	@Test
	public void profileTest() throws UnreachableDataBaseException, ProfileNotFoundException{
		ProfileDAO dao = new ProfileDAO();
		dao.createProfile("teste");
		assertEquals("teste",dao.findProfileByName("teste").getName());
	}
	
	@After
	@Test
	public void userTest() throws ProfileNotFoundException, UnreachableDataBaseException, UserNotFoundException {
		ProfileDAO dao1 = new ProfileDAO();
		UserDAO dao2 = new UserDAO();
		
		dao2.addUser("a@b.c.d", "teste", "1234", dao1.findProfileByName("teste"));
		assertEquals("a@b.c.d",dao2.findUserByEmail("a@b.c.d").getEmail());
	}
	
}
