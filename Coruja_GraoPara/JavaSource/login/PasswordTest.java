package login;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTest {

	String s1 = Password.getHash("abcd");
	String s2 = Password.getHash("ab12#$%@,fasfk13t");
	
	@Test
	public void testGetHash01() {
		String s3 = Password.getHash("ab12#$%@,fasfk13t");
		assertTrue("ok", !s1.equals(s3));
	}
	
	@Test
	public void testGetHash02() {
		String s3 = Password.getHash("abcd"); 
		assertEquals(s1, s3);
	}
	
	@Test
	public void testGetHash03() {
		String s3 = Password.getHash("ab12#$%@,fasfk13t"); 
		assertEquals(s2, s3);
	}

}
