package DAO;

import static org.junit.Assert.*;


import org.junit.Test;

import exceptions.UnreachableDataBaseException;
import exceptions.UserNotFoundException;


public class LoginDAOTest {
	LoginDAO loginDAO = new LoginDAO();

	@Test
	public void testLoginDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUsersByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		String email = "gmail@gmail.com";

		try {
			loginDAO.addUser(email, "gmail", "password");

			assertEquals(email, loginDAO.findUserByEmail(email).getEmail());

		} catch (UnreachableDataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateProfile() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindProfileByName() {
		fail("Not yet implemented");
	}

}
