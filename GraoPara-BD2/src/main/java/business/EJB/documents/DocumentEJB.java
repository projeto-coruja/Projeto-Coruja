package business.EJB.documents;

import persistence.dto.Documento;
import persistence.dto.TipoDocumento;
import business.DAO.document.CodiceCaixaDAO;
import business.DAO.document.DocumentoDAO;
import business.DAO.document.PalavraChaveDAO;
import business.DAO.document.TemaPalavraChaveDAO;
import business.DAO.document.TipoDocumentoDAO;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentEJB {
	
	private final CodiceCaixaDAO codiceCaixaDAO;
	private final TemaPalavraChaveDAO temaDAO;
	private final PalavraChaveDAO keyWordDao;
	private final TipoDocumentoDAO typeDocumentDAO;
	private final DocumentoDAO docDao;

	public DocumentEJB() {
		codiceCaixaDAO = new CodiceCaixaDAO();
		temaDAO = new TemaPalavraChaveDAO();
		keyWordDao = new PalavraChaveDAO();
		typeDocumentDAO = new TipoDocumentoDAO();
		docDao = new DocumentoDAO();
	}
	
	public synchronized void deletarDocumento(Documento docDto) throws UnreachableDataBaseException{
		TipoDocumento tdDto;
		Long countTipoDocumentoDTO;
		TipoDocumentoDAO dtDao = new TipoDocumentoDAO();

		tdDto = docDto.getTipoDocumento();
		docDao.removeDocument(docDto);
		countTipoDocumentoDTO = docDao.countDocumentsByCriteria("tipo_documento = '" + tdDto.getNome() + "'");
		
		if(countTipoDocumentoDTO == 0){
			dtDao.removeDocumentType(tdDto);
		}

	}

}
