package business.EJB.documents;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.PalavraChave;
import business.DAO.document.PalavraChaveDAO;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class KeyWordEJB {
	
	PalavraChaveDAO keyWordDAO;

	public KeyWordEJB() {
		keyWordDAO = new PalavraChaveDAO();
	}

	public PalavraChave buscarPalavraChave(String searchKeyWord) throws UnreachableDataBaseException, KeywordNotFoundException, IllegalArgumentException  {
		
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

	public List<DTO> buscaPalavrasChaves() throws UnreachableDataBaseException, KeywordNotFoundException  {
		return keyWordDAO.getAllKeys();
	}
	
	public synchronized void cadastrarPalavraChave(String palavra, String tema) throws IllegalArgumentException, UnreachableDataBaseException {
		PalavraChaveDAO kwDao = new PalavraChaveDAO();		
		try {
			List<DTO> check = kwDao.findKeyWordByString(palavra);
			for (DTO dto : check) {
				if (((PalavraChave) dto).getPalavra().equals(palavra))
					throw new IllegalArgumentException("Palavra já existe");
			}
			try {
				kwDao.addKeyWord(palavra, tema);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		} catch (KeywordNotFoundException e) {
			try {
				kwDao.addKeyWord(palavra, tema);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		}
	}

	public synchronized void deletarPalavraChave(String keyWord) throws UnreachableDataBaseException, KeywordNotFoundException{
		BuscaDocEJB busca = new BuscaDocEJB();
		List<DTO> results = null;

		keyWord = keyWord.toLowerCase();

		try {
			results = busca.searchByKeyWord(keyWord);
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
				atualizarDocumento(doc);
			}
		} catch (DocumentNotFoundException e) {
			//e.printStackTrace();
		} finally {
			keyWordDAO.removeKeyWord(keyWord);
		}
	}
	
	public synchronized void atualizarPalavraChave(String oldKey, String newKey, Boolean newStatus) throws UnreachableDataBaseException, KeywordNotFoundException , IllegalArgumentException {
		if(oldKey == null || newKey == null || oldKey.equals("") || newKey.equals("") || newStatus == null)	
			throw new IllegalArgumentException("Argumentos não podem ser null/vazio");

		BuscaDocEJB busca = new BuscaDocEJB();
		List<DTO> results = null;

		try {
			results = busca.searchByKeyWord(oldKey);
			for(DTO dto : results){
				DocumentoDTO doc = (DocumentoDTO) dto;
				if(doc.getPalavrasChaves1() != null && doc.getPalavrasChaves1().getPalavra().equals(oldKey)){
					doc.setPalavrasChaves1(doc.getPalavrasChaves2());
					doc.setPalavrasChaves2(doc.getPalavrasChaves3());
					doc.setPalavrasChaves3(null);
				}
				if(doc.getPalavrasChaves2() != null && doc.getPalavrasChaves2().getPalavra().equals(oldKey)){
					doc.setPalavrasChaves2(doc.getPalavrasChaves3());
					doc.setPalavrasChaves3(null);
				}
				if(doc.getPalavrasChaves3() != null && doc.getPalavrasChaves3().getPalavra().equals(oldKey)){
					doc.setPalavrasChaves3(null);
				}
			}
			PalavraChaveDTO keyWordDTO = keyDao.updateKeyWord(oldKey.toLowerCase(), newKey.toLowerCase(), newStatus);

			for(DTO dto : results){
				DocumentoDTO doc = (DocumentoDTO) dto;
				if(doc.getPalavrasChaves1() == null){
					doc.setPalavrasChaves1(keyWordDTO);
				}
				else if(doc.getPalavrasChaves2() == null){
					doc.setPalavrasChaves2(keyWordDTO);
				}
				else if(doc.getPalavrasChaves3() == null){
					doc.setPalavrasChaves3(keyWordDTO);
				}
				atualizarDocumento(doc);
			}
		} catch (DocumentNotFoundException e) {
			@SuppressWarnings("unused")
			PalavraChaveDTO keyWordDTO = keyDao.updateKeyWord(oldKey.toLowerCase(), newKey.toLowerCase(), newStatus);
		} 

	}

}
