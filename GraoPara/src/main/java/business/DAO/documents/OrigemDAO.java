package business.DAO.documents;

import java.util.List;

import business.exceptions.documents.OriginNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.OrigemDTO;
import persistence.utility.DataAccessLayerException;

public class OrigemDAO {

	private PersistenceAccess manager;
	
	public OrigemDAO() {
		manager = new PersistenceAccess();
		
	}

	public OrigemDTO addOrigem(String codOrigem, String tipoOrigem, String titulo) throws UnreachableDataBaseException {
		OrigemDTO newId = new OrigemDTO(codOrigem, tipoOrigem, titulo);
		try{
			manager.saveEntity(newId);
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		}
		return newId;
	}
	
	public List<DTO> findOriginByCod(String cod) throws  UnreachableDataBaseException, OriginNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Origem where codorigem like '" + cod +"'");
			if(resultSet == null) {
				throw new OriginNotFoundException ("Código não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findOriginByType(String type) throws  UnreachableDataBaseException, OriginNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Origem where tipoorigem like '" + type +"'");
			if(resultSet == null) {
				throw new OriginNotFoundException ("Tipo não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findOriginByTitle(String title) throws  UnreachableDataBaseException, OriginNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Origem where titulo like '%" + title +"%'");
			if(resultSet == null) {
				throw new OriginNotFoundException ("Título não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
}