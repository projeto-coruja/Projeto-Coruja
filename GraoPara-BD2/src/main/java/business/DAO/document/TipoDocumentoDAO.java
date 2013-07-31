package business.DAO.document;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.TipoDocumento;
import persistence.exceptions.DataAccessLayerException;
import persistence.exceptions.UpdateEntityException;

public class TipoDocumentoDAO {

	private PersistenceAccess manager;

	public TipoDocumentoDAO() {
		manager = new PersistenceAccess();	
	}
	
	/**
	 * Adiciona um novo Tipo de Documento.
	 * @param tipoDocumento uma String contendo o tipo do documento.
	 * @param descricao uma String contendo a descrição do documento.
	 * @return o objeto TipoDocumento criado. 
	 * @throws UnreachableDataBaseException
	 */
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
	
	/**
	 * Remove um TipoDocumento específico.
	 * @param docType um objeto TipoDocumento a ser removido.
	 * @throws UnreachableDataBaseException
	 */
	public void removeDocumentType(TipoDocumento docType) throws UnreachableDataBaseException {
		if(docType == null)	throw new IllegalArgumentException("Nenhum tipo especificado");
		try{
			manager.deleteEntity(docType);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Atualiza um TipoDocumento específico.
	 * @param docType um objeto TipoDocumento a ser atualizado.
	 * @throws UnreachableDataBaseException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws UpdateEntityException
	 */
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
	
	/**
	 * Procura TipoDocumento.
	 * @param name uma String contendo o nome do TipoDocumento.
	 * @return uma lista de TipoDocumento.
	 * @throws UnreachableDataBaseException
	 * @throws DocumentTypeNotFoundException
	 */
	public List<DTO> findDocumentTypeByString(String name) throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from TipoDocumentoMO where nome = '" + normalize(name) +"' order by nome, descricao");
			if(resultSet == null) {
				throw new DocumentTypeNotFoundException ("Tipo não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Procura TipoDocumento.
	 * @param name uma String contendo o nome do TipoDocumento.
	 * @return o objeto TipoDocumento achado.
	 * @throws UnreachableDataBaseException
	 * @throws DocumentTypeNotFoundException
	 */
	public TipoDocumento findSingleDocumentTypeByString(String name) throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from TipoDocumentoMO where nome = '" + normalize(name) +"' order by nome, descricao");
			if(resultSet == null) {
				throw new DocumentTypeNotFoundException ("Tipo não encontrado");
			}
			else return (TipoDocumento) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Lista todos os TipoDocumento existentes.
	 * @return uma lista de TipoDocumento já existentes.
	 * @throws UnreachableDataBaseException
	 * @throws DocumentTypeNotFoundException
	 */
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

	/**
	 * Formata a palavra-chave a ser uasada na função findEntity().
	 * @param var uma string.
	 * @return a string formatada.
	 */
	private String normalize(String var){
		if(var == null)	return null;
		var = var.replace("'", "''");
//		var = var.replace("\"", "\\\"");
		return var;
	}
}
