package Persistence.EntityCreator;

public class TipoDocumentoFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public Object createEntity(Object dto) {
		TipoDocumento newEnt = new TipoDocumento();
		OrigemDTO entry = (OrigemDTO) dto;
		
		newEnt.setTipoDocumento(entry.getTipoDocumento());
		
		return newEnt;
	}

}
