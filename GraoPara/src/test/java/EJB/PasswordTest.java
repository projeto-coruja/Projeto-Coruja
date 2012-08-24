package EJB;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.EJB.util.EJBUtility;

public class PasswordTest {
	
	String pass;
	String hash;

	@Before
	@Test
	public void genPassword(){
		for(int i = 0; i < 100; i++) System.out.println(EJBUtility.genNewRandomPassword(6));
		pass = EJBUtility.genNewRandomPassword(6);
		System.out.println(pass);
		assertNotNull(pass);
	}
	
	@Test
	public void getHash() {
		hash = EJBUtility.getHash(pass,"MD5");
		System.out.println(hash);
		assertNotNull(hash);
	}
	

}
