package business.DAO.documents;

import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.utility.DataAccessLayerException;
import business.exceptions.documents.IdNumDocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class IdNumDocumentoDAO {
	private PersistenceAccess manager;

	public IdNumDocumentoDAO() {
		manager = new PersistenceAccess();
	}

	public IdNumDocumentoDTO addIdNumDocument(String tipoId, String codId)
			throws UnreachableDataBaseException, IllegalArgumentException {
		if (tipoId.equals("APEP") || tipoId.equals("SEQ")) {
			IdNumDocumentoDTO newId = new IdNumDocumentoDTO(tipoId, codId);
			try {
				manager.saveEntity(newId);
			} catch (DataAccessLayerException e) {
				e.printStackTrace();
				throw new UnreachableDataBaseException(
						"Erro ao acessar o banco de dados");
			}
			return newId;
		}
		else throw new IllegalArgumentException("Tipo deve ser \"APEP\" ou \"SEQ\"");
	}

	public void removeIdNumDocument(IdNumDocumentoDTO id)
			throws UnreachableDataBaseException {
		if (id == null)
			throw new IllegalArgumentException("Nenhum id especificado");
		try {
			manager.deleteEntity(id);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException(
					"Erro ao acessar o banco de dados");
		}
	}

	public void updateIdNumDocument(IdNumDocumentoDTO id)
			throws UnreachableDataBaseException {
		if (id == null)
			throw new IllegalArgumentException("Nenhum id especificado");
		try {
			manager.updateEntity(id);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException(
					"Erro ao acessar o banco de dados");
		}
	}

	public List<DTO> listIdByType(String type)
			throws UnreachableDataBaseException, IdNumDocumentNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager
					.findEntities("from IdNumDocumento where tipoid '" + type
							+ "'");
			if (resultSet == null) {
				throw new IdNumDocumentNotFoundException("Tipo não encontrado");
			} else
				return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException(
					"Erro ao acessar o banco de dados");
		}
	}

	public List<DTO> findIdByCodId(String cod)
			throws UnreachableDataBaseException, IdNumDocumentNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager
					.findEntities("from IdNumDocumento where codId = '" + cod
							+ "'");
			if (resultSet == null) {
				throw new IdNumDocumentNotFoundException(
						"Código não encontrado");
			} else
				return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException(
					"Erro ao acessar o banco de dados");
		}
	}
	
	public IdNumDocumentoDTO findExactId(String cod, String type)
			throws UnreachableDataBaseException, IdNumDocumentNotFoundException {
		IdNumDocumentoDTO select = null;
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntities("from IdNumDocumento where codId = '" + cod + "' and tipo_id = '" + type + "'");
			if (resultSet == null) {
				throw new IdNumDocumentNotFoundException("Código não encontrado");
			} else {
				for(DTO dto : resultSet){
					if(((IdNumDocumentoDTO)dto).getTipoId().equals(type) && ((IdNumDocumentoDTO)dto).getCodId().equals(cod))
						select = (IdNumDocumentoDTO) dto;
				}
				return select;
			}
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
}