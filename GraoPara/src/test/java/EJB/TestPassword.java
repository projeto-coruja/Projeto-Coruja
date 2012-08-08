package EJB;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.EJB.userEJB.Password;

public class TestPassword {
	
	String pass;
	String hash;

	@Before
	@Test
	public void genPassword(){
		for(int i = 0; i < 100; i++) System.out.println(Password.genNewRandomPassword(6));
		pass = Password.genNewRandomPassword(6);
		System.out.println(pass);
		assertNotNull(pass);
	}
	
	@Test
	public void getHash() {
		hash = Password.getHash(pass);
		System.out.println(hash);
		assertNotNull(hash);
	}
	

}
