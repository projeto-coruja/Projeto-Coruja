package business.DAO.document;

import java.util.List;

import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.ThemeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.PalavraChave;
import persistence.dto.TemaPalavraChave;
import persistence.exceptions.DataAccessLayerException;
import persistence.exceptions.UpdateEntityException;

public class PalavraChaveDAO {

	private PersistenceAccess manager;

	public PalavraChaveDAO() {
		manager = new PersistenceAccess();	
	}
	
	/**
	 * Adiciona uma nova Palavra-Chave.
	 * @param key uma String contendo a palavra-chave.
	 * @param theme uma String contendo o tema da Palavra-Chave. 
	 * @return o objeto Palavra-Chave criado.
	 * @throws UnreachableDataBaseException
	 * @throws ThemeNotFoundException
	 */
	public PalavraChave addKeyWord(String key, String theme) throws UnreachableDataBaseException, ThemeNotFoundException{
		TemaPalavraChaveDAO newThemeDAO = new TemaPalavraChaveDAO();
		TemaPalavraChave newTheme = null;
		
		List<DTO> check = newThemeDAO.findThemeByString(theme);
		for (DTO dto : check) {
			if(((TemaPalavraChave) dto).getTema().equals(theme)){
				newTheme = (TemaPalavraChave) dto;
			}
		}
		
		PalavraChave newKey = new PalavraChave(key, newTheme);
		
		try{
			manager.saveEntity(newKey);
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		}
		return newKey;
	}
	
	/**
	 * Remove uma Palavra-Chave.
	 * @param key uma String contendo a palavra-chave.
	 * @throws UnreachableDataBaseException
	 * @throws KeywordNotFoundException
	 */
	public void removeKeyWord(String key) throws UnreachableDataBaseException, KeywordNotFoundException{
		List<DTO> check = null;
		PalavraChave select = null;
		try{
			check = findKeyWordByString(key);
			for(DTO dto : check){
				if (((PalavraChave) dto).getPalavra().equals(key))
					select = (PalavraChave) dto;
			}
			if(select == null)	throw new KeywordNotFoundException("Palavra-chave não encontrado.");
			manager.deleteEntity(select);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Atualiza uma Palavra-Chave.
	 * @param key uma String contendo a palavra-chave a ser atualizada.
	 * @param newKey uma String contendo a palavra-chave nova.
	 * @param newTheme ums String contendo o tema novo da Palavra-Chave.
	 * @return o objeto Palavra-Chave atualizado.
	 * @throws UnreachableDataBaseException
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException
	 * @throws KeywordNotFoundException
	 */
	public PalavraChave updateKeyWord(String key, String newKey, String newTheme) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException, KeywordNotFoundException {
		List<DTO> check = null;
		PalavraChave select_pc = null;
		TemaPalavraChave select_tpc = null;
		
		boolean unmodifiedTheme = false;
		try {
			if(newTheme != null && !newTheme.isEmpty()){
				try{	
					check = (new TemaPalavraChaveDAO()).findThemeByString(newTheme);
					for(DTO dto : check) {
						if(((TemaPalavraChave) dto).getTema().equals(newTheme))
							select_tpc = (TemaPalavraChave) dto;
					}
				} catch(DataAccessLayerException e){
					e.printStackTrace();
					throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
				} catch (ThemeNotFoundException e) {
					throw new IllegalArgumentException("Tema não existe.");
				}
			}
			else unmodifiedTheme = true;
			
			check = findKeyWordByString(key);
			for(DTO dto : check) {
				if(((PalavraChave) dto).getPalavra().equals(key))
					select_pc = (PalavraChave) dto;
			}
			
			if(!unmodifiedTheme) select_pc.setTema(select_tpc);
			select_pc.setPalavra(newKey);
			manager.updateEntity(select_pc);

		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
		
		return select_pc;
	}
	
	/**
	 * Procura Palavra-Chave.
	 * @param key uma String contendo a palavra-chave.
	 * @return uma lista de Palavras-Chave.
	 * @throws UnreachableDataBaseException
	 * @throws KeywordNotFoundException
	 */
	public List<DTO> findKeyWordByString(String key) throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from PalavraChaveMO where palavra like '%" + normalize(key) + "%' order by tema, palavra");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Palavra não encontrada");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Procura Palavra-Chave pelo tema.
	 * @param theme uma String contendo o tema da Palavra-Chave.
	 * @return uma lista de Palavras-Chave.
	 * @throws UnreachableDataBaseException
	 * @throws KeywordNotFoundException
	 */
	public List<DTO> findKeyWordByTheme(String theme) throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from PalavraChaveMO where tema.tema = '" + theme + "' order by tema, palavra");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Tema não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Lista todas as Palavras-Chave existentes.
	 * @return uma lista de Palavras-Chave já existentes.
	 * @throws UnreachableDataBaseException
	 * @throws KeywordNotFoundException
	 */
	public List<DTO> getAllKeys() throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from PalavraChaveMO order by tema.tema");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Nenhuma palavra aprovada");
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
