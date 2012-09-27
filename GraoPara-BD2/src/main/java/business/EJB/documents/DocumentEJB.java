package business.EJB.documents;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.TipoDocumento;
import business.DAO.document.CodiceCaixaDAO;
import business.DAO.document.DocumentoDAO;
import business.DAO.document.PalavraChaveDAO;
import business.DAO.document.TemaPalavraChaveDAO;
import business.DAO.document.TipoDocumentoDAO;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentEJB {
	
	private final CodiceCaixaDAO codiceCaixaDAO;
	private final TemaPalavraChaveDAO temaDAO;
	private final PalavraChaveDAO keyWordDao;
	private final TipoDocumentoDAO typeDocumentDAO;
	private final DocumentoDAO docDao;
	
	private static String default_query = "from Documento where ";

	public DocumentEJB() {
		codiceCaixaDAO = new CodiceCaixaDAO();
		temaDAO = new TemaPalavraChaveDAO();
		keyWordDao = new PalavraChaveDAO();
		typeDocumentDAO = new TipoDocumentoDAO();
		docDao = new DocumentoDAO();
	}
	
	public Documento busca(String cod) throws UnreachableDataBaseException, DocumentTypeNotFoundException{

		boolean continue_query = false;
		String query = new String(default_query);

		if(cod != null && !cod.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "cod = '" + cod + "'";
			continue_query = true;
		}

		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return (DocumentoDTO) list.get(0);

	}

}
