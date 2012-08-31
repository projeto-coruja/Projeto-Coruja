package business.EJB.docEJB;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;

import business.DAO.documents.KeyWordDAO;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class BuscaPalavraChaveEJB {
	
	KeyWordDAO key;
	
	public BuscaPalavraChaveEJB() {
		key = new KeyWordDAO();
	}
	
	public PalavraChaveDTO buscarPalavraChave(String searchKeyWord) throws UnreachableDataBaseException, KeywordNotFoundException, IllegalArgumentException  {
		if(searchKeyWord == null || searchKeyWord.isEmpty())	throw new IllegalArgumentException("Nenhuma palavra chave informado");
		List<DTO> list = key.findKeyWordByString(searchKeyWord);
		PalavraChaveDTO keyWord;
		for(DTO dto : list){
			keyWord = (PalavraChaveDTO) dto;
			if(keyWord != null && searchKeyWord.equals(keyWord.getPalavra()))	return keyWord;
		}
		throw new KeywordNotFoundException("Palavra chave não encontrado.");
	}	
	
	public List<DTO> buscaPalavrasChaves() throws UnreachableDataBaseException, KeywordNotFoundException  {
		return key.getAllKeys();
	}
	
	public List<DTO> buscaPalavrasChavesPendentes() throws UnreachableDataBaseException, KeywordNotFoundException  {
		return key.getAllPendentKeys();
	}

}
