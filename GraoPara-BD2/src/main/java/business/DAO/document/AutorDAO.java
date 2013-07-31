package business.DAO.document;

import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.Autor;
import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;
import business.exceptions.documents.AuthorNotFoundException;
import business.exceptions.documents.DuplicatedAuthorException;
import business.exceptions.login.UnreachableDataBaseException;

public class AutorDAO {

	private PersistenceAccess manager;
	
	public AutorDAO() {
		manager = new PersistenceAccess();
	}
	
	/**
	 * Adiciona um novo Autor.
	 * @param nome uma Stirng contendo o nome do Autor.
	 * @param ocupacao uma Stirng contendo a ocupação do Autor.
	 * @return o novo objeto Autor criado.
	 * @throws UnreachableDataBaseException
	 * @throws DuplicatedAuthorException
	 */
	public Autor addAutor(String nome, String ocupacao) 
			throws UnreachableDataBaseException, DuplicatedAuthorException {
		Autor newAuthor = new Autor(nome, ocupacao);
		try{
			findAuthorByNameAndOccupation(nome, ocupacao);
			throw new DuplicatedAuthorException("Autor duplicado.");
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		} catch (AuthorNotFoundException e) {
			manager.saveEntity(newAuthor);
			return newAuthor;
		}
	}

	/**
	 * Remove o Autor especificado.
	 * @param author o objeto Autor a ser removido.
	 * @throws UnreachableDataBaseException
	 */
	public void removeAuthor(Autor author) throws UnreachableDataBaseException{
		try{
			manager.deleteEntity(author);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados.");
		}
	}
	
	/**
	 * Atualiza Códice/Caixa.
	 * @param author o objeto Autor a ser associado com o códice/caixa.
	 * @throws UnreachableDataBaseException
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException
	 */
	public void updateCodiceCaixa(Autor author) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException{
		try{
			manager.updateEntity(author);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

	/**
	 * Procura o Autor pelo nome e ocupação.
	 * @param name uma String contendo o nome do Autor.
	 * @param occupation uma String contendo a ocupação do Autor.
	 * @return o objeto Autor achado.
	 * @throws AuthorNotFoundException
	 * @throws UnreachableDataBaseException
	 */
	public Autor findAuthorByNameAndOccupation(String name, String occupation) throws AuthorNotFoundException, UnreachableDataBaseException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from AutorMO where nome = '" 
					+ normalize(name) +"'"
					+ " and ocupacao = '" + normalize(occupation) +"'" 
					+ " order by nome, ocupacao");
			if(resultSet == null) {
				throw new AuthorNotFoundException ("Autor não encontrado.");
			}
			else return (Autor) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Procura o Autor pelo nome.
	 * @param name uma String contendo o nome do Autor.
	 * @return uma lista de Autores com o mesmo nome.
	 * @throws AuthorNotFoundException
	 * @throws UnreachableDataBaseException
	 */
	public List<DTO> findAutorByName(String name) throws AuthorNotFoundException, UnreachableDataBaseException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from AutorMO where nome = '" 
					+ normalize(name) +"'"
					+ " order by nome, ocupacao");
			if(resultSet == null) {
				throw new AuthorNotFoundException ("Autor não encontrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Lista todos os Autores existentes.
	 * @return uma lista de Autores já existentes.
	 * @throws UnreachableDataBaseException
	 * @throws AuthorNotFoundException
	 */
	public List<DTO> findAllAuthor() throws UnreachableDataBaseException, AuthorNotFoundException {
		List<DTO> resultSet = null;
		try{
			resultSet = manager.findEntity("from AutorMO order by order by nome, ocupacao");
			if(resultSet == null) {
				throw new AuthorNotFoundException("Não existe nenhum autor cadastrado.");
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
