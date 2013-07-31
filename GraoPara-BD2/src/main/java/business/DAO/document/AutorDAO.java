package business.DAO.document;

import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.Autor;
import persistence.dto.DTO;
import persistence.exceptions.DataAccessLayerException;
import persistence.exceptions.UpdateEntityException;
import business.exceptions.documents.AuthorNotFoundException;
import business.exceptions.documents.DuplicatedAuthorException;
import business.exceptions.login.UnreachableDataBaseException;

public class AutorDAO {

	private PersistenceAccess manager;
	
	public AutorDAO() {
		manager = new PersistenceAccess();
	}
	
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

	public void removeAuthor(Autor author) throws UnreachableDataBaseException{
		try{
			manager.deleteEntity(author);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados.");
		}
	}
	
	public void updateCodiceCaixa(Autor author) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException{
		try{
			manager.updateEntity(author);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

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

	private String normalize(String var){
		if(var == null)	return null;
		var = var.replace("'", "''");
//		var = var.replace("\"", "\\\"");
		return var;
	}
}
