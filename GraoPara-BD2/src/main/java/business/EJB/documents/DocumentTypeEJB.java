package business.EJB.documents;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import persistence.dto.DTO;
import persistence.dto.TipoDocumento;
import persistence.exceptions.UpdateEntityException;

import business.DAO.document.TipoDocumentoDAO;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.documents.DuplicatedDocumentTypeException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentTypeEJB {
	
	private TipoDocumentoDAO typeDoc;

	public DocumentTypeEJB() {
		typeDoc = new TipoDocumentoDAO();
	}

	public List<DTO> listAllTypeDocuments() throws UnreachableDataBaseException, DocumentTypeNotFoundException{
		return typeDoc.findAllDocumentTypes();
	}

	public synchronized void addNewDocumentType(String type, String description) throws UnreachableDataBaseException, DuplicatedDocumentTypeException{
		TipoDocumentoDAO dao = new TipoDocumentoDAO();
		TipoDocumento dto = null;
		try{
			dto = dao.findSingleDocumentTypeByString(type);
			if(dto != null)	throw new DuplicatedDocumentTypeException("Tipo de documento já existe");
		}catch(DocumentTypeNotFoundException e){
			dao.addDocumentType(type, description);
		}
	}
	
	public synchronized void updateNewDocumentType(String type, String description) 
			throws UpdateEntityException, UnreachableDataBaseException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		TipoDocumentoDAO dao = new TipoDocumentoDAO();
		TipoDocumento dto = null;
		try{
			dto = dao.findSingleDocumentTypeByString(type);
			dto.setNome(type);
			dto.setDescricao(description);
			dao.updateDocumentType(dto);
		}catch(DocumentTypeNotFoundException e){
			dao.addDocumentType(type, description);
		}
	}

	public synchronized void removeTypeDocument(String deletingType) throws UnreachableDataBaseException, DocumentTypeNotFoundException{
		DocumentEJB search = new DocumentEJB();
		TipoDocumento type = typeDoc.findSingleDocumentTypeByString(deletingType);
		try {
			search.findByDocumentType(deletingType);
			throw new IllegalArgumentException("Tentativa de remoção de tipo de documento que possue associação a algum documento.");
		} catch (DocumentNotFoundException e) {
			typeDoc.removeDocumentType(type);
			e.printStackTrace();
		}

	}

}
