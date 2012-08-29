package business.EJB.docEJB;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.TipoDocumentoDTO;

import business.DAO.documents.DocumentTypeDAO;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

@SuppressWarnings("unused")
public class TipoDocumentoEJB {

	private DocumentTypeDAO typeDoc;
	
	public TipoDocumentoEJB() {
		typeDoc = new DocumentTypeDAO();
	}
	
	public List<DTO> listAllTypeDocuments() throws UnreachableDataBaseException, DocumentTypeNotFoundException{
		return typeDoc.findAllDocumentTypes();
	}
	
	public void removeTypeDocument(String type) throws UnreachableDataBaseException, DocumentTypeNotFoundException, DocumentNotFoundException{
		BuscaDocEJB search = new BuscaDocEJB();
		
		List<DTO> documentTypeDTO = typeDoc.findDocumentTypeByString(type);
		List<DTO> documentList = search.buscaPorTipoDocumento(type);
		
		for (DTO dto : documentList) {
			
		}
		
	}
	
}
