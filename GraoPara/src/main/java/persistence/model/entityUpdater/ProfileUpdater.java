package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.ProfileDTO;
import persistence.model.Entidade;
import persistence.model.Profile;

public class ProfileUpdater implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		ProfileDTO entry = (ProfileDTO) dto;
		
		((Profile) ent).setProfile(entry.getProfile());
		((Profile) ent).setEdit(entry.isEdit());
		((Profile) ent).setRead(entry.isRead());
		((Profile) ent).setWrite(entry.isWrite());
		
		return ent;
	}

}
