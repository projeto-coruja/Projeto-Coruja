package business.EJB.documents;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.PalavraChave;
import persistence.dto.TemaPalavraChave;
import business.DAO.document.PalavraChaveDAO;
import business.DAO.document.TemaPalavraChaveDAO;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.ThemeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class ThemeEJB {
	
	TemaPalavraChaveDAO themeDAO;
	
	public ThemeEJB() {
		themeDAO = new TemaPalavraChaveDAO();
	}
	
	public List<DTO> searchAllThemes() throws UnreachableDataBaseException, ThemeNotFoundException  {
		return themeDAO.getAllThemes();
	}
	
	public synchronized void registerThemes(String tema) throws IllegalArgumentException, UnreachableDataBaseException {
		if(tema == null || tema.isEmpty())	throw new IllegalArgumentException("Parameter is null/empty");
		TemaPalavraChaveDAO theme = new TemaPalavraChaveDAO();
		try {
			List<DTO> check = theme.findThemeByString(tema);
			for (DTO dto : check) {
				if (((TemaPalavraChave) dto).getTema().equals(tema))
					throw new IllegalArgumentException("Palavra já existe");
			}
			throw new ThemeNotFoundException();
		} catch (ThemeNotFoundException e) {
			try {
				theme.addThemeWord(tema);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public synchronized void updateThemes(String oldTheme, String newTheme) throws UnreachableDataBaseException, KeywordNotFoundException {
		
		PalavraChaveDAO palavraChaveDAO = new PalavraChaveDAO();
		List<DTO> resultSet = null;
		List<DTO> listTheme = null;
		
		try {
			listTheme = themeDAO.findThemeByString(newTheme);
			if(listTheme==null)
				throw new Exception();
			
			resultSet = palavraChaveDAO.findKeyWordByTheme(oldTheme);
			for (DTO dto : resultSet) {
				//palavraChaveDAO.updateKeyWord(dto., newKey, newTheme)
				palavraChaveDAO.updateKeyWord(
						((PalavraChave)dto).getPalavra(), 
						((PalavraChave)dto).getPalavra(), 
						newTheme
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
