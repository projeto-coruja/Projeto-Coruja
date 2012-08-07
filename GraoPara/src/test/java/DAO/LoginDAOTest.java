package DAO;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import business.EJB.AuthBean;
import business.EJB.CadastroBean;
import business.exceptions.DuplicateUserException;
import business.exceptions.IncorrectLoginInformationException;
import business.exceptions.UnreachableDataBaseException;
import business.exceptions.UserNotFoundException;


public class LoginDAOTest {
//	LoginDAO loginDAO = new LoginDAO();

	@Before
	@Test
	public void testAddUser() throws DuplicateUserException, UserNotFoundException {
		String email = "outlook@gmail.com";
		String pass = "password";
		CadastroBean cf = new CadastroBean();
		try {
			cf.adicionarUsuario(email, "gmail", pass);

			assertTrue(AuthBean.validarLogin(email, pass, AuthBean.NonHashedPwd));

		} catch (UnreachableDataBaseException e) {
			System.out.println("DEU ERRO EM MIM GALVÃO!!!! db");
			e.printStackTrace();
		} catch (IncorrectLoginInformationException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveUser() {

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
