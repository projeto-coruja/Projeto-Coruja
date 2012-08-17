package EJB.docEJB;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
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
	
	private static String origem_codOrigem;
	private static String origem_tipoOrigem;
	private static String origem_titulo;
	private static String idNumDoc_tipoId;
	private static String idNumDoc_codId;
	private static String tipoDocumento_tipoDocumento;
	private static String palavraChave01;
	private static String palavraChave02;
	private static String palavraChave03; 
	private static String autor;
	private static String local;
	private static String destinatario; 
	private static String resumo;
	private static Calendar dataDocumento;
	private static String uploader;
	
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
		
		origem_codOrigem = "ABC";
		origem_tipoOrigem = "CODICE";
		origem_titulo = "TITULO DA ORIGEM!";
		idNumDoc_tipoId = "APEP";
		idNumDoc_codId = "123";
		tipoDocumento_tipoDocumento = "CARTA";
		palavraChave01 = "TESTE1";
		palavraChave02 = "TESTE2";
		palavraChave03 = "TESTE3";
		autor = "EU";
		local = "Pará";
		destinatario = "VOCE";
		resumo = "3R# UM# V%Z, 1M G#T& ÇHI~NÉ'S'\"\"\nNEH";
		dataDocumento = new GregorianCalendar(1500, 4, 29);
		uploader = "outlook@gmail.com";
		
		
		ce.cadastrarDocumento(origem_codOrigem, origem_tipoOrigem, origem_titulo,
				idNumDoc_tipoId, idNumDoc_codId,
				tipoDocumento_tipoDocumento, palavraChave01, palavraChave02, palavraChave03,
				autor, local, destinatario, resumo, dataDocumento, uploader);
		
		
	}
	
	@Test
	public void testBusca() {
		try {
			/*List<DTO> resultset = bde.busca(origem_tipoOrigem, origem_codOrigem, idNumDoc_tipoId, idNumDoc_codId, autor,
					destinatario, local, "1500-05-29", tipoDocumento_tipoDocumento, 
					palavraChave01, palavraChave02, palavraChave03);*/
			List<DTO> resultset = bde.busca(origem_tipoOrigem, origem_codOrigem, idNumDoc_tipoId, idNumDoc_codId, autor,
					destinatario, local, "1500-05-29", tipoDocumento_tipoDocumento, 
					palavraChave01, palavraChave02, palavraChave03);
//			ce.deletarDocumento(resultset.get(0).getId());
			((DocumentoDTO)resultset.get(0)).setAutor("EU DE NOVO");
			ce.atualizarDocumento((DocumentoDTO) resultset.get(0));
			if(resultset != null){
				System.out.println(((DocumentoDTO) resultset.get(0)).getResumo());
				System.out.println(bde.countRowsByCriteria("tipo_id = 'APEP'"));
			}
		} catch (UnreachableDataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
