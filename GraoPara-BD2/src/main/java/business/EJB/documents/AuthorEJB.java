package business.EJB.documents;

import java.util.List;

import persistence.dto.Autor;
import persistence.dto.DTO;
import business.DAO.document.AutorDAO;
import business.exceptions.documents.AuthorNotFoundException;
import business.exceptions.documents.DuplicatedAuthorException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * EJB de autor.
 */
public class AuthorEJB {
	
	private AutorDAO dao;
	
	public AuthorEJB(){
		dao = new AutorDAO();
	}
	
	/**
	 * Adiciona um novo autor
	 * @param name - Nome do autor
	 * @param occupation - Ocupação do autor.
	 * @throws UnreachableDataBaseException
	 * @throws DuplicatedAuthorException quando o autor já existe no banco de dados.
	 */
	public void addNewAuthor(String name, String occupation) throws UnreachableDataBaseException, DuplicatedAuthorException{
		try {
			dao.findAuthorByNameAndOccupation(name, occupation);
		} catch (AuthorNotFoundException e) {
			dao.addAutor(name, occupation);
			e.printStackTrace();
		}
	}
	
	/**
	 * Remove um autor.
	 * @param name - Nome do autor
	 * @param occupation - Ocupação do autor.
	 * @throws UnreachableDataBaseException
	 */
	public void removeAuthor(String name, String occupation) throws UnreachableDataBaseException{
		Autor author;
		try {
			author = dao.findAuthorByNameAndOccupation(name, occupation);
			dao.removeAuthor(author);
		} catch (AuthorNotFoundException e){
		}
	}
	
	/**
	 * Lista todos os autores cadastrados.
	 * @return Lista de autores.
	 * @throws UnreachableDataBaseException
	 * @throws AuthorNotFoundException
	 */
	public List<DTO> listAllAuthors() throws UnreachableDataBaseException, AuthorNotFoundException{
		return dao.findAllAuthor();
	}
	
}
