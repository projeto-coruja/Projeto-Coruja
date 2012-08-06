package EJB;

import static org.junit.Assert.*;

import org.junit.Test;

import business.EJB.RegularExpression;


public class RegularExpressionTest {
	
	String expressao = "([A-Za-z0-9])([A-Za-z0-9]|_|-|.)*@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)+";
	
	RegularExpression p = new RegularExpression( expressao );
	
	
	@Test
	public void testCheckTrue() {
		assertTrue(p.check("asb@gac.com"));
		assertTrue(p.check("asb@gac.com.br"));
		assertTrue(p.check("a.sb@gac.com.br.sa.ce.go"));
		assertTrue(p.check("as_09@gac.com"));
		assertTrue(p.check("Asg25_sa-AS.HGe215@gA3tTac.cCsom.Agea3.EAG31da"));
	}
	
	@Test
	public void testCheckFalse() {
		assertFalse(p.check("asb@gac"));
		assertFalse(p.check("asb"));
		assertFalse(p.check("asb@gac"));
		assertFalse(p.check("asb@gac."));
		assertFalse(p.check("asb@gac.ae."));
		assertFalse(p.check("@gac"));
		assertFalse(p.check("asb@.co"));
		assertFalse(p.check("as.b@gac"));
	}
	
}
