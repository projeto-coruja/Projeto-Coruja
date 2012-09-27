package business.EJB.documents;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.Documento;
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
		TemaPalavraChaveDAO theme = new TemaPalavraChaveDAO();		
		try {
			List<DTO> check = theme.findThemeByString(tema);
			for (DTO dto : check) {
				if (((TemaPalavraChave) dto).getTema().equals(tema))
					throw new IllegalArgumentException("Palavra já existe");
			}
			try {
				theme.addThemeWord(tema);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		} catch (ThemeNotFoundException e) {
			try {
				theme.addThemeWord(tema);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public synchronized void deleteThemes(String tema) throws UnreachableDataBaseException, KeywordNotFoundException {
		List<DTO> results = null;
		PalavraChaveDAO palavra = new PalavraChaveDAO();

	}

}
