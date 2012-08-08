package business.DAO.documents;

import java.util.List;

import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.utility.DataAccessLayerException;

public class KeyWordDAO {

	private PersistenceAccess manager;
	
	public KeyWordDAO() {
		manager = new PersistenceAccess();	
	}
	
	public List<DTO> findKeywordByString(String key) throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where palavra like '" + key +"'");
			if(resultSet == null) {
				throw new KeywordNotFoundException ("Palavra não encontrada");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> getAllApprovedKeys() throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where aprovada like 'true'");
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
			resultSet = manager.findEntities("from Documento where aprovada like 'false'");
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
