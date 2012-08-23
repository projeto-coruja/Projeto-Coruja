package business.DAO.documents;

import java.util.List;

import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;
import persistence.utility.DataAccessLayerException;

public class KeyWordDAO {

	private PersistenceAccess manager;
	
	public KeyWordDAO() {
		manager = new PersistenceAccess();	
	}
	
	public PalavraChaveDTO addKeyWord(String key) throws UnreachableDataBaseException{
		PalavraChaveDTO newKey = new PalavraChaveDTO(key.toLowerCase(),false);
		try{
			manager.saveEntity(newKey);
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		}
		return newKey;
	}

	public void removeKeyWord(String key) throws UnreachableDataBaseException, UserNotFoundException, KeywordNotFoundException{
		PalavraChaveDTO check = null;
		try{
			check = (PalavraChaveDTO) findKeyWordByString(key);
			manager.deleteEntity(check);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findKeyWordByString(String key) throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from PalavraChave where palavra = '" + key + "'");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Palavra não encontrada");
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
			resultSet = manager.findEntities("from PalavraChave");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Nenhuma palavra aprovada");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> getAllPendentKeys() throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from PalavraChave where aprovada = false");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Nenhuma palavra esperando por aprovação");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
}