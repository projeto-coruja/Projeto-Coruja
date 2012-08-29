package business.EJB.docEJB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	public void addNewDocumentType(String type) throws UnreachableDataBaseException{
		DocumentTypeDAO dao = new DocumentTypeDAO();
		TipoDocumentoDTO dto;
		
		try{
			dto = dao.findSingleDocumentTypeByString(type);
		}catch(DocumentTypeNotFoundException e){
			dao.addDocumentType(type);
		}
		
	}
	
	public void removeTypeDocument(String deletingType) throws UnreachableDataBaseException, DocumentTypeNotFoundException{
		BuscaDocEJB search = new BuscaDocEJB();
		
		TipoDocumentoDTO type = typeDoc.findSingleDocumentTypeByString(deletingType);
		List<DTO> documentList;
		try {
			documentList = search.buscaPorTipoDocumento(deletingType);
			throw new IllegalArgumentException("Tentativa de remoção de tipo de documento que possue associação a algum documento.");
		} catch (DocumentNotFoundException e) {
			typeDoc.removeDocumentType(type);
		}
		
	}
	
}
