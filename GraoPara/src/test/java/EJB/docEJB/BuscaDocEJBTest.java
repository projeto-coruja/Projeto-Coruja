package EJB.docEJB;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.dto.UserDTO;
import webview.WebUtility;
import business.DAO.login.LoginDAO;
import business.EJB.docEJB.BuscaDocEJB;
import business.EJB.docEJB.CadastroEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class BuscaDocEJBTest {
	
	private static BuscaDocEJB bde;
	private static CadastroEJB ce;
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
		UO = LA.findUserByEmail("outlook@gmail.com");
		if (UO == null) {
			LA.addUser("outlook@gmail.com", "Outlook", "password");
			UO = LA.findUserByEmail("outlook@gmail.com");
		}
		
		ce.cadastrarDocumento("ABC", "CODICE", "TITULO DA ORIGEM!", "APEP", "EFG",
				"CARTA", "TESTE", "", "", "EU", "AQUI",
				"VOCE", "3R# UM# V%Z, 1M G#T& ÇHI~NÉ'S'\"\"\nNEH", new GregorianCalendar(1500, 3, 29), "outlook@gmail.com");
	}
	
	@Test
	public void testBusca() {
		try {
			List<DTO> resultset = bde.busca("CODICE", null, null, null, null, null, null, null, null, null, null, null);
			if(resultset != null)
				System.out.println(((DocumentoDTO) resultset.get(0)).getResumo());
		} catch (UnreachableDataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
