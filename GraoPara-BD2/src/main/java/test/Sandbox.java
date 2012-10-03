package test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import business.DAO.login.ProfileDAO;
import business.DAO.login.UserDAO;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

@SuppressWarnings("unused")
public class Sandbox {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws UnreachableDataBaseException 
	 * @throws ProfileNotFoundException 
	 */
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, UnreachableDataBaseException, ProfileNotFoundException {
		ProfileDAO dao = new ProfileDAO();
		dao.createProfile("teste");
		UserDAO dao2 = new UserDAO();
		dao2.addUser("a@b.c.d", "teste", "1234", dao.findProfileByName("teste"));
		
	}

}
