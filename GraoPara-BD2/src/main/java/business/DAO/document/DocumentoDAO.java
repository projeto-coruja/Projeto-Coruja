package business.DAO.document;

import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.exceptions.DataAccessLayerException;
import persistence.exceptions.UpdateEntityException;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentoDAO {

	private PersistenceAccess manager;

	public DocumentoDAO() {
		manager = new PersistenceAccess();
	}
	
	/**
	 * Adiciona um novo Documento.
	 * @param newDoc o objeto Documento a ser adicionado.
	 * @throws UnreachableDataBaseException
	 */
	public void addDocument(Documento newDoc) throws UnreachableDataBaseException {
		if(newDoc == null)	throw new IllegalArgumentException("newDoc is null");
		try {
			manager.saveEntity(newDoc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Remove um Documento específico.
	 * @param doc o objeto Documento a ser removido.
	 * @throws UnreachableDataBaseException
	 */
	public void removeDocument(Documento doc) throws UnreachableDataBaseException {
		if(doc == null)	throw new IllegalArgumentException("Nenhum documento especificado");
		try{
			manager.deleteEntity(doc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

	/**
	 * Atualiza um Documento específico.
	 * @param doc o objeto a ser atualizado.
	 * @throws UnreachableDataBaseException
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException
	 */
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
	
	/**
	 * Calcula a quantidade de Documentos com a mesma critéria.
	 * @param criteria uma String contendo a critéria dos Documentos.
	 * @return a quantidade de Documentos com a mesma critéria.
	 * @throws IllegalArgumentException
	 */
	public Long countDocumentsByCriteria(String criteria) throws IllegalArgumentException{
		return manager.countRows("Documento", criteria);
	}

	/**
	 * Procura Documentos pelo Query.
	 * @param query uma Stirng.
	 * @return uma lista de Documentos.
	 * @throws DocumentNotFoundException
	 * @throws UnreachableDataBaseException
	 */
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
