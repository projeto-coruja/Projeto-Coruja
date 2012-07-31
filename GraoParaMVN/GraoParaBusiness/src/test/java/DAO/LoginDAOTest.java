package DAO;

import static org.junit.Assert.*;


import org.junit.Ignore;
import org.junit.Test;

import EJB.AutenticacaoFacade;
import EJB.CadastroFacade;

import exceptions.IncorrectLoginInformationException;
import exceptions.UnreachableDataBaseException;
import exceptions.UserNotFoundException;


public class LoginDAOTest {
//	LoginDAO loginDAO = new LoginDAO();

	@Test
	public void testLoginDAO() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindUserByEmail() {
		String email = "gmail@gmail.com";
		String pass = "password";
		
		
	}

	@Test
	public void testFindUsersByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		String email = "gmail@gmail.com";
		String pass = "password";
		CadastroFacade cf = new CadastroFacade();
		AutenticacaoFacade af = new AutenticacaoFacade();
		try {
			cf.adicionarUsuario(email, "gmail", pass);

			assertTrue(af.validarLogin(email, pass));

		} catch (UnreachableDataBaseException e) {
			System.out.println("DEU ERRO EM MIM GALVÃO!!!! db");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			System.out.println("DEU ERRO EM MIM GALVÃO!!!! user");
			e.printStackTrace();
		} catch (IncorrectLoginInformationException e) {
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
