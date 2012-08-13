package persistence.model.entityUpdater;

import persistence.dto.*;
import persistence.model.Entidade;

public class EntityChanger {

	private EntityUpdate updater;
	
	public EntityChanger() {
		updater = null;
	}
	
	public Entidade updateEntity(DTO dto, Entidade ent) {
		if(dto == null) return null;
		
		if(dto instanceof UserDTO)
			updater = new UserUpdater();
		else if(dto instanceof ProfileDTO)
			updater = new ProfileUpdater();
		else if(dto instanceof DocumentoDTO)
			updater = new DocumentoUpdater();
		else if(dto instanceof TipoDocumentoDTO)
			updater = new TipoDocumentoUpdater();
		else if(dto instanceof IdNumDocumentoDTO)
			updater = new IdNumDocumentoUpdater();
		else if(dto instanceof OrigemDTO)
			updater = new OrigemUpdater();
		else if(dto instanceof PalavraChaveDTO)
			updater = new PalavraChaveUpdater();
		else throw new IllegalArgumentException();
		
		return updater.updateEntity(dto, ent);
	}

}
