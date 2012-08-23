package business.DAO.documents;

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
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.documents.IdNumDocumentNotFoundException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.OriginNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentDAO {
	
	private PersistenceAccess manager;
	
	public DocumentDAO() {
		manager = new PersistenceAccess();
	}
	
	public void addDocument(DocumentoDTO newDoc) throws UnreachableDataBaseException {
		
		List<DTO> check;
		DocumentTypeDAO dtd = new DocumentTypeDAO();
		IdNumDocumentoDAO indd = new IdNumDocumentoDAO();
		KeyWordDAO kwd = new KeyWordDAO();
		OrigemDAO od = new OrigemDAO();
		
		
		// Verificação de existência do tipo de documento no banco
		try {
			check = dtd.findDocumentTypeByString(newDoc.getTipoDocumento().getTipoDocumento());
			for(DTO dto : check){
				if(((TipoDocumentoDTO) dto).getTipoDocumento().equals(newDoc.getTipoDocumento().getTipoDocumento()))
					newDoc.setTipoDocumento((TipoDocumentoDTO) dto);
			}
		} catch (DocumentTypeNotFoundException e1) {	
			newDoc.setTipoDocumento(dtd.addDocumentType(newDoc.getTipoDocumento().getTipoDocumento()));
		}

		// Verificação de existência do id do documento no banco
		try {
			check = indd.findIdByCodId(newDoc.getIdNumDocumento().getTipoId());
			for(DTO dto : check){
				if(		((IdNumDocumentoDTO) dto).getTipoId().equals(newDoc.getIdNumDocumento().getTipoId()) &&
						((IdNumDocumentoDTO) dto).getCodId().equals(newDoc.getIdNumDocumento().getCodId()))
					newDoc.setIdNumDocumento((IdNumDocumentoDTO) dto);
			}
		} catch (IdNumDocumentNotFoundException e1) {
			newDoc.setIdNumDocumento(indd.addIdNumDocument(newDoc.getIdNumDocumento().getTipoId(), newDoc.getIdNumDocumento().getCodId()));
		}

		// Verificação de existência das palavras chaves documento no banco
		if(newDoc.getPalavrasChaves1() != null)
		{
			try {
				check = kwd.findKeyWordByString(newDoc.getPalavrasChaves1().getPalavra());
				for(DTO dto : check){
					if(((PalavraChaveDTO) dto).getPalavra().equals(newDoc.getPalavrasChaves1().getPalavra()))
						newDoc.setPalavrasChaves1((PalavraChaveDTO) dto);
				}
			} catch (KeywordNotFoundException e1) {
				newDoc.setPalavrasChaves1(kwd.addKeyWord(newDoc.getPalavrasChaves1().getPalavra()));
			}
		}
		else throw new IllegalArgumentException("Palavra-chave principal não pode ser nula.");
	
		if(newDoc.getPalavrasChaves2() != null)
		{
			try {
				check = kwd.findKeyWordByString(newDoc.getPalavrasChaves2().getPalavra());
				for(DTO dto : check){
					if(((PalavraChaveDTO) dto).getPalavra().equals(newDoc.getPalavrasChaves2().getPalavra()))
						newDoc.setPalavrasChaves2((PalavraChaveDTO) dto);
				}
			} catch (KeywordNotFoundException e1) {
				newDoc.setPalavrasChaves2(kwd.addKeyWord(newDoc.getPalavrasChaves2().getPalavra()));
			}
		}
		
		if(newDoc.getPalavrasChaves3() != null)
		{
			try {
				check = kwd.findKeyWordByString(newDoc.getPalavrasChaves3().getPalavra());
				for(DTO dto : check){
					if(((PalavraChaveDTO) dto).getPalavra().equals(newDoc.getPalavrasChaves3().getPalavra()))
						newDoc.setPalavrasChaves3((PalavraChaveDTO) dto);
				}
			} catch (KeywordNotFoundException e1) {
				newDoc.setPalavrasChaves3(kwd.addKeyWord(newDoc.getPalavrasChaves3().getPalavra()));
			}
		}
		
		// Verificação de existência da origem do documento no banco
		try {
			check = od.findOriginByTitle(newDoc.getOrigemDocumento().getTitulo());
			for(DTO dto : check){
				if(((OrigemDTO) dto).getTitulo().equals(((OrigemDTO) dto).getTitulo()) &&
						((OrigemDTO) dto).getTipoOrigem().equals(((OrigemDTO) dto).getTipoOrigem()) &&
						((OrigemDTO) dto).getCodOrigem().equals(((OrigemDTO) dto).getCodOrigem()))
					newDoc.setOrigemDocumento((OrigemDTO) check);
			}
		} catch (OriginNotFoundException e1) {
			newDoc.setOrigemDocumento(od.addOrigem(newDoc.getOrigemDocumento().getCodOrigem(), newDoc.getOrigemDocumento().getTipoOrigem(), newDoc.getOrigemDocumento().getTitulo()));
		}
		
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
			if(doc.getId() == null) addDocument(doc);	
			else manager.updateEntity(doc);
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
		
	public List<DTO> findDocumentByQuery(String query) throws DocumentNotFoundException, UnreachableDataBaseException{
		List<DTO> resultSet = null;
		if(query == null)	throw new IllegalArgumentException("Query não pode ser null");
		try {
			resultSet = manager.findEntities(query);
			if(resultSet == null) {
				throw new  DocumentNotFoundException("Nenhum documento encontrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public Long countDocumentsByCriteria(String criteria) throws IllegalArgumentException{
		return manager.countRows("Documento", criteria);
	}
}