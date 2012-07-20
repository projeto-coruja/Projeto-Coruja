package Persistence.DTO.DTOCreator;

import Persistence.Model.*;

import java.util.ArrayList;
import java.util.List;

public class DTOGenerator {

	private DTOFactory factory;
	
	public DTOGenerator() {
		factory = null;
	}

	@SuppressWarnings("rawtypes")
	public List generateDTOSet(List resultSet) {
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
		for(Object x : resultSet)
		{
			DTOset.add(factory.createDTO(x));
		}
		return DTOset;
	}

}
