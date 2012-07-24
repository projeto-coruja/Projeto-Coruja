package persistence.dto.dtoCreator;


import java.util.ArrayList;
import java.util.List;

import persistence.dto.DTO;
import persistence.model.*;

public class DTOGenerator {

	private DTOFactory factory;
	
	public DTOGenerator() {
		factory = null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<DTO> generateDTOSet(List<Entidade> resultSet) {
		if (resultSet.isEmpty()) return null;
		Object ent = resultSet.get(0);
		
		if(ent instanceof User)
			factory = new UserDTOFactory();
		else if(ent instanceof Profile)
			factory = new ProfileDTOFactory();
		else if(ent instanceof Documento)
			factory = new DocumentoDTOFactory();
		else if(ent instanceof TipoDocumento)
			factory = new TipoDocumentoDTOFactory();
		else if(ent instanceof IdNumDocumento)
			factory = new IdNumDocumentoDTOFactory();
		else if(ent instanceof Origem)
			factory = new OrigemDTOFactory();
		else if(ent instanceof PalavraChave)
			factory = new PalavraChaveDTOFactory();
		else throw new IllegalArgumentException();
		
		List DTOset = new ArrayList();
		for(Entidade x : resultSet)
		{
			DTOset.add(factory.createDTO(x));
		}
		return DTOset;
	}
	
	public DTO generateSingleDTO(Entidade ent) {
		if(ent == null) return null;
		
		if(ent instanceof User)
			factory = new UserDTOFactory();
		else if(ent instanceof Profile)
			factory = new ProfileDTOFactory();
		else if(ent instanceof Documento)
			factory = new DocumentoDTOFactory();
		else if(ent instanceof TipoDocumento)
			factory = new TipoDocumentoDTOFactory();
		else if(ent instanceof IdNumDocumento)
			factory = new IdNumDocumentoDTOFactory();
		else if(ent instanceof Origem)
			factory = new OrigemDTOFactory();
		else if(ent instanceof PalavraChave)
			factory = new PalavraChaveDTOFactory();
		else throw new IllegalArgumentException();
		
		return factory.createDTO(ent);
	}

}
