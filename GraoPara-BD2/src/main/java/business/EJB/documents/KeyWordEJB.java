package business.EJB.documents;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.PalavraChave;
import persistence.exceptions.UpdateEntityException;
import business.DAO.document.PalavraChaveDAO;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class KeyWordEJB {
	
	PalavraChaveDAO keyWordDAO;

	public KeyWordEJB() {
		keyWordDAO = new PalavraChaveDAO();
	}

	public PalavraChave findByString(String searchKeyWord) throws UnreachableDataBaseException, KeywordNotFoundException, IllegalArgumentException  {
		
		if(searchKeyWord == null || searchKeyWord.isEmpty())
			throw new IllegalArgumentException("Nenhuma palavra chave informado");
		
		List<DTO> list = keyWordDAO.findKeyWordByString(searchKeyWord);
		PalavraChave keyWord;
		
		for(DTO dto : list){
			
			keyWord = (PalavraChave) dto;
			
			if(keyWord != null && searchKeyWord.equals(keyWord.getPalavra()))
				return keyWord;
		}
		
		throw new KeywordNotFoundException("Palavra chave não encontrado.");
	}
	
	public List<DTO> getAllKeyWords() throws UnreachableDataBaseException, KeywordNotFoundException{
		return keyWordDAO.getAllKeys();
	}
	
	public List<DTO> findByTheme(String theme) throws UnreachableDataBaseException, KeywordNotFoundException{
		return keyWordDAO.findKeyWordByTheme(theme);
	}

	public List<DTO> buscaPalavrasChaves() throws UnreachableDataBaseException, KeywordNotFoundException  {
		return keyWordDAO.getAllKeys();
	}
	
	public synchronized void addKeyWord(String palavra, String tema) throws IllegalArgumentException, UnreachableDataBaseException {
		PalavraChaveDAO kwDao = new PalavraChaveDAO();		
		try {
			List<DTO> check = kwDao.findKeyWordByString(palavra);
			for (DTO dto : check) {
				if (((PalavraChave) dto).getPalavra().equals(palavra))
					throw new IllegalArgumentException("Palavra já existe");
			}
			try {
				kwDao.addKeyWord(palavra.toLowerCase(), tema);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		} catch (KeywordNotFoundException e) {
			try {
				kwDao.addKeyWord(palavra.toLowerCase(), tema);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		}
	}

	public synchronized void removeKeyWord(String keyWord) throws UnreachableDataBaseException, KeywordNotFoundException{
		DocumentEJB docEJB = new DocumentEJB();
		List<DTO> results = null;

		keyWord = keyWord.toLowerCase();

		try {
			results = docEJB.findByKeyWord(keyWord);
			for(DTO dto : results){
				Documento doc = (Documento) dto;
				if(doc.getPalavraChave1() != null && doc.getPalavraChave1().getPalavra().equals(keyWord)){
					doc.setPalavraChave1(doc.getPalavraChave2());
					doc.setPalavraChave2(doc.getPalavraChave3());
					doc.setPalavraChave3(null);
				}
				if(doc.getPalavraChave2() != null && doc.getPalavraChave2().getPalavra().equals(keyWord)){
					
					doc.setPalavraChave2(doc.getPalavraChave3());
					doc.setPalavraChave3(null);
				}
				if(doc.getPalavraChave3() != null && doc.getPalavraChave3().getPalavra().equals(keyWord)){
					doc.setPalavraChave3(null);
				}
				docEJB.modifyDocument(doc);
			}
		} catch (DocumentNotFoundException e) {
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (UpdateEntityException e) {
			e.printStackTrace();
		} finally {
			keyWordDAO.removeKeyWord(keyWord);
		}
	}
	
	public synchronized void updateKeyWord(String oldKey, String newKey, String newTheme) throws UnreachableDataBaseException, KeywordNotFoundException , IllegalArgumentException, UpdateEntityException {
		if(oldKey == null || newKey == null || oldKey.equals("") || newKey.equals("") || newTheme == null || newTheme.isEmpty())	
			throw new IllegalArgumentException("Argumentos não podem ser null/vazio");

		keyWordDAO.updateKeyWord(oldKey.toLowerCase(), newKey.toLowerCase(), newTheme);
	}

}
