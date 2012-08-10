package DAO;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;

import business.DAO.login.LoginDAO;
import business.EJB.userEJB.AdminBean;
import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.CadastroBean;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;


public class LoginDAOTest {
//	LoginDAO loginDAO = new LoginDAO();

	@Ignore
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

	LoginDAO ld;
	AdminBean ab;
	
	@Before
	public void setUp(){
		ld = new LoginDAO();
		ab = new AdminBean();
		try {
			ab.adicionarProfile("teste", true, false, false);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (IncorrectProfileInformationException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testlistUsersByProfile() {
		for(int i = 0; i < 100; i++){
			String email = "user"+i+"@aaa.aaa";
			String name = "user"+i;
			String pass = "password";
			try {
				ld.addUser(email, name, pass);
				ab.alterarPermissoesUsuario(email, "teste");
			} catch (UnreachableDataBaseException e) {
				e.printStackTrace();
			} catch (IncorrectProfileInformationException e) {
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			} catch (ProfileNotFoundException e) {
				e.printStackTrace();
			}
		}
		List<DTO> urs = null;
		try {
			urs = ld.listUsersByProfile("teste");
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		for(DTO userTest : urs){
			System.out.println(((UserDTO)userTest).getEmail());
		}
	}
	
}
