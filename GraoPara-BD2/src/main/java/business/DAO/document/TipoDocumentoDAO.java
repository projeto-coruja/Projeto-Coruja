package business.DAO.document;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.TipoDocumento;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;

public class TipoDocumentoDAO {

	private PersistenceAccess manager;

	public TipoDocumentoDAO() {
		manager = new PersistenceAccess();	
	}
	
	public TipoDocumento addDocumentType(String tipoDocumento, String descricao) throws UnreachableDataBaseException{
		TipoDocumento newType = new TipoDocumento(tipoDocumento, descricao);
		try{
			manager.saveEntity(newType);
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		}
		return newType;
	}
	
	public void removeDocumentType(TipoDocumento docType) throws UnreachableDataBaseException {
		if(docType == null)	throw new IllegalArgumentException("Nenhum tipo especificado");
		try{
			manager.deleteEntity(docType);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void updateDocumentType(TipoDocumento docType) 
			throws UnreachableDataBaseException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, NoSuchMethodException, SecurityException, UpdateEntityException {
		
		if(docType == null) throw new IllegalArgumentException("Tipo de documento inexistente!");
		try { 
			if(docType.getId() == null)	addDocumentType(docType.getNome(), docType.getDescricao());
			else	manager.updateEntity(docType);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentTypeByString(String name) throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from TipoDocumentoMO where nome = '" + name +"' order by nome, descricao");
			if(resultSet == null) {
				throw new DocumentTypeNotFoundException ("Tipo não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public TipoDocumento findSingleDocumentTypeByString(String name) throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from TipoDocumentoMO where nome = '" + name +"' order by nome, descricao");
			if(resultSet == null) {
				throw new DocumentTypeNotFoundException ("Tipo não encontrado");
			}
			else return (TipoDocumento) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findAllDocumentTypes() throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from TipoDocumentoMO order by nome, descricao");
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
