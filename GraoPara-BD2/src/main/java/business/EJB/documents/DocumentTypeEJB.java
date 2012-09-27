package business.EJB.documents;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.TipoDocumento;

import business.DAO.document.TipoDocumentoDAO;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentTypeEJB {
	
	private TipoDocumentoDAO typeDoc;

	public DocumentTypeEJB() {
		typeDoc = new TipoDocumentoDAO();
	}

	public List<DTO> listAllTypeDocuments() throws UnreachableDataBaseException, DocumentTypeNotFoundException{
		return typeDoc.findAllDocumentTypes();
	}

	public synchronized void addNewDocumentType(String type, String description) throws UnreachableDataBaseException{
		TipoDocumentoDAO dao = new TipoDocumentoDAO();
		TipoDocumento dto = null;
		try{
			dto = dao.findSingleDocumentTypeByString(type);
		}catch(DocumentTypeNotFoundException e){
			dao.addDocumentType(type, description);
		}

	}

	public synchronized void removeTypeDocument(String deletingType) throws UnreachableDataBaseException, DocumentTypeNotFoundException{
		BuscaDocEJB search = new BuscaDocEJB();

		TipoDocumento type = typeDoc.findSingleDocumentTypeByString(deletingType);
		List<DTO> documentList;
		try {
			documentList = search.buscaPorTipoDocumento(deletingType);
			throw new IllegalArgumentException("Tentativa de remoção de tipo de documento que possue associação a algum documento.");
		} catch (DocumentTypeNotFoundException e) {
			typeDoc.removeDocumentType(type);
		}

	}

}
