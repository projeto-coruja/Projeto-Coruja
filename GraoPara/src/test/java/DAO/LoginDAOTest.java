package DAO;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.CadastroBean;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;


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

			assertTrue(AuthBean.validarLogin(email, pass, AuthBean.NonHashedPwd) > AuthBean.LoginFail);

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
