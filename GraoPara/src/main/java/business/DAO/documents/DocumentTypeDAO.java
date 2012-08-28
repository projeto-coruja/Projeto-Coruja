package business.DAO.documents;

import java.util.List;

import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.utility.DataAccessLayerException;

public class DocumentTypeDAO {

	private PersistenceAccess manager;
	
	public DocumentTypeDAO() {
		manager = new PersistenceAccess();	
	}

	public TipoDocumentoDTO addDocumentType(String tipoDocumento) throws UnreachableDataBaseException{
		TipoDocumentoDTO newType = new TipoDocumentoDTO(tipoDocumento);
		try{
			manager.saveEntity(newType);
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		}
		return newType;
	}

	public void removeDocumentType(TipoDocumentoDTO docType) throws UnreachableDataBaseException {
		if(docType == null)	throw new IllegalArgumentException("Nenhum tipo especificado");
		try{
			manager.deleteEntity(docType);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void updateDocumentType(TipoDocumentoDTO docType) throws UnreachableDataBaseException {
		if(docType == null) throw new IllegalArgumentException("Tipo de documento inexistente!");
		try { 
			if(docType.getId() == null)	addDocumentType(docType.getTipoDocumento());
			else	manager.updateEntity(docType);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentTypeByString(String type) throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from TipoDocumento where tipoDocumento = '" + type +"'");
			if(resultSet == null) {
				throw new DocumentTypeNotFoundException ("Tipo não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findAllDocumentTypes() throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from TipoDocumento order by tipoDocumento");
			if(resultSet == null) {
				throw new DocumentTypeNotFoundException ("Tipo não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
}