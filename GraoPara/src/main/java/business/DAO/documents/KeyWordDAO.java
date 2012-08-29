package business.DAO.documents;

import java.util.List;

import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
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
	
	public PalavraChaveDTO addKeyWord(String key, Boolean status) throws UnreachableDataBaseException{
		PalavraChaveDTO newKey = new PalavraChaveDTO(key.toLowerCase(),status);
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
		PalavraChaveDTO select = null;
		try{
			check = findKeyWordByString(key);
			for(DTO dto : check){
				if (((PalavraChaveDTO) dto).getPalavra().equals(key))
					select = (PalavraChaveDTO) dto;
			}
			if(select == null)	throw new KeywordNotFoundException("Palavra-chave não encontrado.");
			manager.deleteEntity(select);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}	
	
	public PalavraChaveDTO approveKeyWord(String key) throws UnreachableDataBaseException, KeywordNotFoundException{
		List<DTO> check = null;
		PalavraChaveDTO select = null;
		try{
			check = findKeyWordByString(key);
			for(DTO dto : check){
				if (((PalavraChaveDTO) dto).getPalavra().equals(key))
					select = (PalavraChaveDTO) dto;
			}
			select.setAprovada(true);
			manager.updateEntity(select);
			return select;
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public PalavraChaveDTO updateKeyWord(String oldKey, String newKey, Boolean newStatus) throws UnreachableDataBaseException, KeywordNotFoundException{
		List<DTO> check = null;
		PalavraChaveDTO select = null;
		try{
			check = findKeyWordByString(oldKey);
			for(DTO dto : check){
				if (((PalavraChaveDTO) dto).getPalavra().equals(oldKey))
					select = (PalavraChaveDTO) dto;
			}
			try{
				check = findKeyWordByString(newKey);
				for(DTO dto : check){
					if (((PalavraChaveDTO) dto).getPalavra().equals(newKey))
						throw new IllegalArgumentException("Palavra chave nova já existente");
				}
			} catch (KeywordNotFoundException e){}
			select.setPalavra(newKey);
			select.setAprovada(newStatus);
			manager.updateEntity(select);
			return select;
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public List<DTO> findKeyWordByString(String key) throws  UnreachableDataBaseException, KeywordNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from PalavraChave where palavra like '%" + key.toLowerCase() + "%'");
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