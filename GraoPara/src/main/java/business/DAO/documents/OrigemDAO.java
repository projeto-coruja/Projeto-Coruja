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
	
	public void removeOrigin(OrigemDTO origin) throws UnreachableDataBaseException{
		try{
			manager.deleteEntity(origin);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void updateOrigin(OrigemDTO origin) throws UnreachableDataBaseException{
		try{
			manager.updateEntity(origin);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public OrigemDTO findExactOrigin(String cod, String type) throws  UnreachableDataBaseException, OriginNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Origem where cod_origem like '" + cod +"' and tipo_origem like '" + type +"'");
			OrigemDTO select = null;
			if(resultSet == null) {
				throw new OriginNotFoundException ("Origem não encontrado");
			}
			for(DTO d : resultSet){
				if(((OrigemDTO)d).getCodOrigem().equals(cod) && ((OrigemDTO)d).getTipoOrigem().equals(type))
					select = (OrigemDTO) d;
			}
			if(select == null)	throw new OriginNotFoundException ("Origem não encontrado");
			return select;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findOriginByCod(String cod) throws  UnreachableDataBaseException, OriginNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Origem where cod_origem like '" + cod +"'");
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
			resultSet = manager.findEntities("from Origem where tipo_origem like '" + type +"'");
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
	
	public List<DTO> findAllOrigins() throws  UnreachableDataBaseException, OriginNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from Origem");
			if(resultSet == null) {
				throw new OriginNotFoundException ("Tipo não encontrado");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
}