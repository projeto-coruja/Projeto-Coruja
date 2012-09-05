package business.DAO.documents;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.DAO.login.LoginDAO;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

import persistence.PersistenceAccess;
import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import webview.WebUtility;

public class DocumentDAOTest {

	private static DocumentDAO DA;
	private static LoginDAO LA;
	private static UserDTO UO;

	@BeforeClass
	public static void setUp() throws UnreachableDataBaseException {

		PersistenceAccess pa = new PersistenceAccess();

		pa.saveEntity(WebUtility.default_profile);
		pa.saveEntity(WebUtility.user_profile);
		pa.saveEntity(WebUtility.admin_profile);

		LA = new LoginDAO();
		DA = new DocumentDAO();
		try {
			UO = LA.findUserByEmail("outlook@gmail.com");
		} catch (UserNotFoundException e) {
			LA.addUser("outlook@gmail.com", "Outlook", "password", null);
			try {
				UO = LA.findUserByEmail("outlook@gmail.com");
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (UO == null) {
		}
	}

	@Before
	public void testDocumentDAO() {
		assertNotNull(DA);
	}

	@Test
	public void testAddDocument() throws UnreachableDataBaseException, UserNotFoundException {
		DocumentoDTO carta = new DocumentoDTO(null, new OrigemDTO("A362",
				"APEP", "histórias do conde de notre dame"),
				new IdNumDocumentoDTO("APEP", "10202"), new TipoDocumentoDTO(
						"carta"), "pero vaz", "pará", "vaz pero",
				"loren ipsum loren ipsum loren ipsum loren ipsum",
				new Date(), new Date(),
				LA.findUserByEmail("outlook@gmail.com"), new PalavraChaveDTO(
						"cabral", false), null, null);
		DA.addDocument(carta);
//		System.out.println(DA.countDocumentsByCriteria("tipo_id = 'APEP'"));
	}

	@Test
	public void testRemoveDocument() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDocument() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDocumentsByOrigin() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDocumentsByAutor() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDocumentsByLocal() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDocumentsByRecipient() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDocumentsBySummary() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDocumentsByUploader() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDocumentsByKeyWord() {
		fail("Not yet implemented");
	}

}
