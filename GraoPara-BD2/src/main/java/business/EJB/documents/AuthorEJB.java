package business.EJB.documents;

import java.util.List;

import persistence.dto.Autor;
import persistence.dto.DTO;
import business.DAO.document.AutorDAO;
import business.exceptions.documents.AuthorNotFoundException;
import business.exceptions.documents.DuplicatedAuthorException;
import business.exceptions.login.UnreachableDataBaseException;

public class AuthorEJB {
	
	private AutorDAO dao;
	
	public AuthorEJB(){
		dao = new AutorDAO();
	}
	
	public void addNewAuthor(String name, String occupation) throws UnreachableDataBaseException, DuplicatedAuthorException{
		try {
			dao.findAuthorByNameAndOccupation(name, occupation);
		} catch (AuthorNotFoundException e) {
			dao.addAutor(name, occupation);
			e.printStackTrace();
		}
	}
	
	public void removeAuthor(String name, String occupation) throws UnreachableDataBaseException{
		Autor author;
		try {
			author = dao.findAuthorByNameAndOccupation(name, occupation);
			dao.removeAuthor(author);
		} catch (AuthorNotFoundException e){
		}
	}
	
	public List<DTO> listAllAuthors() throws UnreachableDataBaseException, AuthorNotFoundException{
		return dao.findAllAuthor();
	}
	
}
