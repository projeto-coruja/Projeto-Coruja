package EJB.docEJB;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import persistence.PersistenceAccess;
import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import webview.WebUtility;

import business.DAO.documents.DocumentDAO;
import business.DAO.login.LoginDAO;
import business.EJB.docEJB.BuscaDocEJB;
import business.EJB.docEJB.CadastroEJB;
import business.exceptions.login.UnreachableDataBaseException;

public class BuscaDocEJBTest {
	
	private static BuscaDocEJB bde;
	private static CadastroEJB ce;
	private static DocumentDAO DA;
	private static LoginDAO LA;
	private static UserDTO UO;
	
	@BeforeClass
	public static void setUp() throws UnreachableDataBaseException{
		ce = new CadastroEJB();
		bde = new BuscaDocEJB();
		
		PersistenceAccess pa = new PersistenceAccess();

		pa.saveEntity(WebUtility.default_profile);
		pa.saveEntity(WebUtility.user_profile);
		pa.saveEntity(WebUtility.admin_profile);

		LA = new LoginDAO();
		DA = new DocumentDAO();
		UO = LA.findUserByEmail("outlook@gmail.com");
		if (UO == null) {
			LA.addUser("outlook@gmail.com", "Outlook", "password");
			UO = LA.findUserByEmail("outlook@gmail.com");
		}
	}

	@Before
	public void testCadastro(){
		BuscaDocEJBTest.ce.cadastrarDocumento("COD", "ABC", "TITULO DA ORIGEM!", "APEP", "EFG",
				"CARTA", "TESTE", "", "", "EU", "AQUI", "VOCE", "ERA UMA VEZ, UM GATO CHINÊS", new GregorianCalendar(1500, 3, 29), new Date(), BuscaDocEJBTest.UO);
	}
	
	@Ignore
	@Test
	public void testBusca() {
		
		
		
	}

}
