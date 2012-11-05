package business.DAO.document;

import java.util.List;

import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.ThemeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.PalavraChave;
import persistence.dto.TemaPalavraChave;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;

public class PalavraChaveDAO {

	private PersistenceAccess manager;

	public PalavraChaveDAO() {
		manager = new PersistenceAccess();	
	}
	
	public PalavraChave addKeyWord(String key, String theme) throws UnreachableDataBaseException{
		TemaPalavraChaveDAO newThemeDAO = new TemaPalavraChaveDAO();
		TemaPalavraChave newTheme = null;
		
		try {
			List<DTO> check = newThemeDAO.findThemeByString(theme);
			for (DTO dto : check) {
				if(((TemaPalavraChave) dto).getTema().equals(theme)){
					newTheme = (TemaPalavraChave) dto;
				}
			}
			
		} catch (ThemeNotFoundException e1) {
			newTheme = newThemeDAO.addThemeWord(theme);
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
	
	public PalavraChave updateKeyWord(String key, String newKey, String newTheme) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException {
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
					TemaPalavraChaveDAO tpcDAO = new TemaPalavraChaveDAO();
					select_tpc = tpcDAO.addThemeWord(newTheme);
				}
			}
			else	unmodifiedTheme = true;
			
			check = findKeyWordByString(key);
			for(DTO dto : check) {
				if(((PalavraChave) dto).getPalavra().equals(key))
					select_pc = (PalavraChave) dto;
			}
			
			if(!unmodifiedTheme)	select_pc.setTema(select_tpc);
			select_pc.setPalavra(newKey);
			manager.updateEntity(select_pc);

		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		} catch (KeywordNotFoundException e) {
			try{	
				check = (new TemaPalavraChaveDAO()).findThemeByString(newTheme);
				for(DTO dto : check) {
					if(((TemaPalavraChave) dto).getTema().equals(newTheme))
						select_tpc = (TemaPalavraChave) dto;
				}
			} catch(DataAccessLayerException e1){
				e.printStackTrace();
				throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
			} catch (ThemeNotFoundException e1) {
				TemaPalavraChaveDAO tpcDAO = new TemaPalavraChaveDAO();
				select_tpc = tpcDAO.addThemeWord(newTheme);
			}
			select_pc = new PalavraChave(newKey,select_tpc);
			manager.saveEntity(select_pc);
		}
		
		return select_pc;
	}
	
	public List<DTO> findKeyWordByString(String key) throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from PalavraChaveMO where palavra like '%" + key + "%' order by tema, palavra");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Palavra não encontrada");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
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
	
}
