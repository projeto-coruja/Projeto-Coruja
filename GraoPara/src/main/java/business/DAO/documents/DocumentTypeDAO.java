package business.DAO.documents;

import java.util.List;

import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.utility.DataAccessLayerException;

public class DocumentTypeDAO {

	private PersistenceAccess manager;
	
	public DocumentTypeDAO() {
		manager = new PersistenceAccess();	
	}
	
	public List<DTO> findKeywordByString(String type) throws  UnreachableDataBaseException, DocumentTypeNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Documento where tipodocumento like '" + type +"'");
			if(resultSet == null) {
				throw new DocumentTypeNotFoundException ("Tipo não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
}
