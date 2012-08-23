package business.EJB.docEJB;

import java.util.List;

import persistence.dto.DTO;

import business.DAO.documents.KeyWordDAO;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class BuscaPalavraChaveEJB {
	
	KeyWordDAO key;
	
	public BuscaPalavraChaveEJB() {
		key = new KeyWordDAO();
	}
	
	public List<DTO> buscaPalavrasChaves() throws UnreachableDataBaseException, KeywordNotFoundException  {
		return key.getAllKeys();
	}
	
	public List<DTO> buscaPalavrasChavesPendentes() throws UnreachableDataBaseException, KeywordNotFoundException  {
		return key.getAllPendentKeys();
	}

}
