package persistence.model.entityCreator;

import persistence.dto.*;
import persistence.model.Entidade;

public class EntityGenerator {

	private EntityFactory factory;
	
	public EntityGenerator() {
		factory = null;
	}
	
	public Entidade generateEntity(DTO dto) {
		if(dto == null) return null;
		
		if(dto instanceof UserDTO)
			factory = new UserFactory();
		else if(dto instanceof ProfileDTO)
			factory = new ProfileFactory();
		else if(dto instanceof DocumentoDTO)
			factory = new DocumentoFactory();
		else if(dto instanceof TipoDocumentoDTO)
			factory = new TipoDocumentoFactory();
		else if(dto instanceof IdNumDocumentoDTO)
			factory = new IdNumDocumentoFactory();
		else if(dto instanceof OrigemDTO)
			factory = new OrigemFactory();
		else if(dto instanceof PalavraChaveDTO)
			factory = new PalavraChaveFactory();
		else throw new IllegalArgumentException();
		
		return factory.createEntity(dto);
	}

}
