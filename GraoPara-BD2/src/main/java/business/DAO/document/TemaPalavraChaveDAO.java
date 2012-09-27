package business.DAO.document;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.ThemeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.TemaPalavraChave;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;

public class TemaPalavraChaveDAO {

	private PersistenceAccess manager;

	public TemaPalavraChaveDAO() {
		manager = new PersistenceAccess();	
	}
	
	public TemaPalavraChave addThemeWord(String theme) throws UnreachableDataBaseException{
		TemaPalavraChave newTheme = new TemaPalavraChave(theme);
		try{
			manager.saveEntity(newTheme);
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		}
		return newTheme;
	}
	
	public TemaPalavraChave updateTheme(String oldTheme, String newTheme) 
			throws UnreachableDataBaseException, ThemeNotFoundException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, NoSuchMethodException, SecurityException, UpdateEntityException {
		List<DTO> check = null;
		TemaPalavraChave select = null;
		try{
			check = findThemeByString(oldTheme);
			for(DTO dto : check){
				if (((TemaPalavraChave) dto).getTema().equals(oldTheme))
					select = (TemaPalavraChave) dto;
			}
			try{
				check = findThemeByString(newTheme);
				for(DTO dto : check){
					if (((TemaPalavraChave) dto).getTema().equals(newTheme))
						throw new IllegalArgumentException("Tema nova já existente");
				}
			} catch (ThemeNotFoundException e){}

			select.setTema(newTheme);

			manager.updateEntity(select);
			return select;
			
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void removeTheme(String theme) throws UnreachableDataBaseException, ThemeNotFoundException {
		List<DTO> check = null;
		TemaPalavraChave select = null;
		try{
			check = findThemeByString(theme);
			for(DTO dto : check){
				if (((TemaPalavraChave) dto).getTema().equals(theme))
					select = (TemaPalavraChave) dto;
			}
			if(select == null)	throw new ThemeNotFoundException("Tema não encontrado.");
			manager.deleteEntity(select);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findThemeByString(String theme) throws  UnreachableDataBaseException, ThemeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from TemaPalavraChaveMO where tema like '%" + theme + "%' order by tema");
			if(resultSet == null) {
				throw new ThemeNotFoundException ("Tema não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> getAllThemes() throws  UnreachableDataBaseException, ThemeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from TemaPalavraChaveMO order by tema");
			if(resultSet == null) {
				throw new ThemeNotFoundException ("Nenhum tema encontrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
}
