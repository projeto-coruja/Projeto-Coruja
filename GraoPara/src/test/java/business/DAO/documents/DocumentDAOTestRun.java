package business.DAO.documents;

import java.util.Date;
import java.util.GregorianCalendar;

import business.DAO.login.LoginDAO;
import business.exceptions.login.UnreachableDataBaseException;

import persistence.PersistenceAccess;
import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import webview.servlets.WebUtility;

public class DocumentDAOTestRun {

	private static DocumentDAO DA;
	private static LoginDAO LA;
	private static UserDTO UO;

	public static void main(String[] args) throws UnreachableDataBaseException {
		setUp();
		testAddDocument();
	}

	public static void setUp() throws UnreachableDataBaseException {

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

	public static void testAddDocument() throws UnreachableDataBaseException {
		DocumentoDTO carta = new DocumentoDTO(null, new OrigemDTO("A362",
				"APEP", "histórias do conde de notre dame"),
				new IdNumDocumentoDTO("APEP", "10202"), new TipoDocumentoDTO(
						"carta"), "pero vaz", "pará", "vaz pero",
				"loren ipsum loren ipsum loren ipsum loren ipsum",
				new GregorianCalendar(1500, 3, 29), new Date(),
				LA.findUserByEmail("outlook@gmail.com"), new PalavraChaveDTO(
						"cabral", false), null, null);
		DA.addDocument(carta);
		System.out.println(DA.countDocumentsByCriteria("tipo_id = 'APEP'"));
	}
}
