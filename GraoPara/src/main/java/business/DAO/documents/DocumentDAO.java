package business.DAO.documents;

import java.util.List;

import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.UserDTO;
import persistence.utility.DataAccessLayerException;

public class DocumentDAO {
	
	private PersistenceAccess manager;
	
	public DocumentDAO() {
		manager = new PersistenceAccess();
		
	}
	

	public List<DTO> findDocumentsByOrigin(String autor) throws  DocumentNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where autor like '" + autor +"'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Autor não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsByAutor(String autor) throws  DocumentNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where autor like '" + autor +"'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Autor não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsByLocal(String local) throws  DocumentNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where local like '" + local +"'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Local não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsByRecipient(String recipient) throws  DocumentNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where destinatario like '" + recipient +"'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Destinatario não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsBySummary(String summary) throws  DocumentNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			//TODO: Modificar para que a busca seja por ocorrencias e não por igualdade
			resultSet = manager.findEntities("from Documento where resumo like '" + summary +"'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Documento não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsByUploader(UserDTO uploader) throws  DocumentNotFoundException, UnreachableDataBaseException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where uploader like '" + uploader +"'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Nenhum documento levantado pelo usuário");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsByKeyWord(PalavraChaveDTO keyword) throws  DocumentNotFoundException, UnreachableDataBaseException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where palavrachave like '" + keyword +"'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Nenhum documento levantado pelo usuário");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	
}
