package business.DAO.documents;

import java.util.Date;
import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import persistence.utility.DataAccessLayerException;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentDAO {
	
	private PersistenceAccess manager;
	
	public DocumentDAO() {
		manager = new PersistenceAccess();
	}
	
	public void addDocument(Long id, OrigemDTO origemDocumento,
			IdNumDocumentoDTO idNumDocumento, TipoDocumentoDTO tipoDocumento,
			String autor, String local, String destinatario, String resumo,
			Date dataDocumento, Date dataInclusao, UserDTO uploader,
			PalavraChaveDTO[] palavrasChaves) throws UnreachableDataBaseException {
		
		DocumentoDTO newDoc = new DocumentoDTO(id, origemDocumento, 
				idNumDocumento, tipoDocumento, autor, local, destinatario, 
				resumo, dataDocumento, dataInclusao, uploader, palavrasChaves);
		
		try {
			manager.saveEntity(newDoc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void removeDocument(DocumentoDTO doc) throws UnreachableDataBaseException {
		if(doc == null)	throw new IllegalArgumentException("Nenhum documento especificado");
		try{
			manager.deleteEntity(doc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void updateDocument(DocumentoDTO doc) throws UnreachableDataBaseException {
		if(doc == null) throw new IllegalArgumentException("Documento inexistente!");
		try { 
			manager.updateEntity(doc);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsByOrigin(OrigemDTO origem) throws  DocumentNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where origemdocumento like '" + origem +"'");
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
			resultSet = manager.findEntities("from Documento where autor like '%" + autor +"%'");
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
			resultSet = manager.findEntities("from Documento where local like '%" + local +"%'");
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Local não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findDocumentsByRecipient(String destinatario) throws  DocumentNotFoundException, UnreachableDataBaseException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where destinatario like '%" + destinatario +"%'");
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
			resultSet = manager.findEntities("from Documento where resumo like '%" + summary +"%'");
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
