package business.DAO.document;

import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentoDAO {

	private PersistenceAccess manager;

	public DocumentoDAO() {
		manager = new PersistenceAccess();
	}
	
	public void addDocument(Documento newDoc) throws UnreachableDataBaseException {
		if(newDoc == null)	throw new IllegalArgumentException("newDoc is null");
		try {
			manager.saveEntity(newDoc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void removeDocument(Documento doc) throws UnreachableDataBaseException {
		if(doc == null)	throw new IllegalArgumentException("Nenhum documento especificado");
		try{
			manager.deleteEntity(doc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

	public void updateDocument(Documento doc) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException {
		if(doc == null) throw new IllegalArgumentException("Documento inexistente!");
		try { 
			if(doc.getId() == null) addDocument(doc);	
			else manager.updateEntity(doc);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public Long countDocumentsByCriteria(String criteria) throws IllegalArgumentException{
		return manager.countRows("Documento", criteria);
	}

	public List<DTO> findDocumentByQuery(String query) throws DocumentNotFoundException, UnreachableDataBaseException{
		List<DTO> resultSet = null;
		if(query == null)	throw new IllegalArgumentException("Query não pode ser null");
		try {
			resultSet = manager.findEntity(query);
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Nenhum documento encontrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
}
