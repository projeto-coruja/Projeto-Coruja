package business.DAO.document;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;

public class CodiceCaixaDAO {
	
	private PersistenceAccess manager;
	
	public CodiceCaixaDAO() {
		manager = new PersistenceAccess();
	}
	
	public CodiceCaixa addCodiceCaixa(String cod, String titulo, int anoInicio, int anoFim) 
			throws UnreachableDataBaseException, DuplicateCodiceCaixaException {
		CodiceCaixa newId = new CodiceCaixa(cod, titulo, anoInicio, anoFim);
		try{
			findExactCodiceCaixa(cod, titulo);
			throw new DuplicateCodiceCaixaException("Codice/Caixa ja existe.");
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		} catch (CodiceCaixaNotFoundException e) {
			manager.saveEntity(newId);
			return newId;
		}
	}
	
	public void removeCodiceCaixa(CodiceCaixa origin) throws UnreachableDataBaseException{
		try{
			manager.deleteEntity(origin);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados.");
		}
	}
	
	public void updateCodiceCaixa(CodiceCaixa origin) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException{
		try{
			manager.updateEntity(origin);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public CodiceCaixa findExactCodiceCaixa(String cod, String titulo) 
			throws  UnreachableDataBaseException, CodiceCaixaNotFoundException  {
		
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from CodiceCaixaMO where cod = '" 
					+ cod +"'"
					+ " and titulo = '" + titulo +"'" 
					+ " order by cod, titulo, anoInicio, anoFim");
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException ("Codice/Caixa não encontrado.");
			}
			else return (CodiceCaixa) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findCodiceCaixaByCod(String cod) throws  UnreachableDataBaseException, CodiceCaixaNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from CodiceCaixaMO where cod like '%" + cod +"%' "
					+ "order by cod, titulo, anoInicio, anoFim");
			
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException ("Código não encontrado.");
			}
			else return resultSet;
		
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findCodiceCaixaByTitle(String titulo) throws  UnreachableDataBaseException, CodiceCaixaNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from CodiceCaixaMO where titulo like '%" + titulo +"%' order by cod, titulo, anoInicio, anoFim");
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException ("Título não encontrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findAllCodiceCaixa() throws  UnreachableDataBaseException, CodiceCaixaNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from CodiceCaixaMO order by order by cod, titulo, anoInicio, anoFim");
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException("Não existe nenhum Codice/Caixa cadastrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

}
