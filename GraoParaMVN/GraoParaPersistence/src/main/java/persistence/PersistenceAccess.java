package persistence;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.ProfileDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import persistence.dto.dtoCreator.DTOGenerator;
import persistence.model.Documento;
import persistence.model.Entidade;
import persistence.model.IdNumDocumento;
import persistence.model.Origem;
import persistence.model.PalavraChave;
import persistence.model.Profile;
import persistence.model.TipoDocumento;
import persistence.model.User;
import persistence.model.entityCreator.EntityGenerator;
import persistence.model.entityUpdater.EntityChanger;
import persistence.utility.EntityManager;


public class PersistenceAccess {

	private DTOGenerator dtoGen;

	private EntityGenerator entGen;
	
	private EntityChanger entChg;

	private EntityManager sharedManager;
	
	public PersistenceAccess() {
		dtoGen = new DTOGenerator();
		entGen = new EntityGenerator();
		entChg = new EntityChanger();
		sharedManager = new EntityManager();
	}

	public void saveEntity(DTO dto) {
		sharedManager.save(entGen.generateEntity(dto));
	}

	public void updateEntity(DTO dto) {
		Entidade target = findTarget(dto);
		sharedManager.update(entChg.updateEntity(dto, target));
	}

	public void deleteEntity(DTO dto) {
		Entidade target = findTarget(dto);
		sharedManager.delete(target);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public DTO findSingleEntity(Class table, long id) {
		return dtoGen.generateSingleDTO(sharedManager.find(table, id));
	}


	public List<DTO> findEntities(String query) {
		return dtoGen.generateDTOSet(sharedManager.find(query));
	}
	
	private Entidade findTarget(DTO dto) {
		
		@SuppressWarnings("rawtypes")
		Class table;
		
		if(dto instanceof UserDTO)
			table = User.class;
		else if(dto instanceof ProfileDTO)
			table = Profile.class;
		else if(dto instanceof DocumentoDTO)
			table = Documento.class;
		else if(dto instanceof TipoDocumentoDTO)
			table = TipoDocumento.class;
		else if(dto instanceof IdNumDocumentoDTO)
			table = IdNumDocumento.class;
		else if(dto instanceof OrigemDTO)
			table = Origem.class;
		else if(dto instanceof PalavraChaveDTO)
			table = PalavraChave.class;
		else throw new IllegalArgumentException();
		
		return sharedManager.find(table, dto.getId());
	}

}