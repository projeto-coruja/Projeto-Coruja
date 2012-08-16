package persistence.model.entityCreator;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.model.Documento;
import persistence.model.IdNumDocumento;
import persistence.model.Origem;
import persistence.model.PalavraChave;
import persistence.model.TipoDocumento;
import persistence.model.User;

public class DocumentoFactory implements EntityFactory {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Documento createEntity(DTO dto) {
		Documento newEnt = new Documento();
		DocumentoDTO entry = (DocumentoDTO) dto;
		
		newEnt.setOrigemDocumento(getOrigem(entry));
		newEnt.setIdentDocumento(getIdNumDocumento(entry));
		newEnt.setTipoDocumento(getTipoDocumento(entry));
		newEnt.setAutor(entry.getAutor());
		newEnt.setDestinatario(entry.getDestinatario());
		newEnt.setLocal(entry.getLocal());
		newEnt.setResumo(entry.getResumo());
		newEnt.setDataInclusao(entry.getDataInclusao());
		newEnt.setDataDocumento(entry.getDataDocumento());
		newEnt.setPalavrasChaves1(getPalavraChave1(entry));	
		newEnt.setPalavrasChaves2(getPalavraChave2(entry));		
		newEnt.setPalavrasChaves3(getPalavraChave3(entry));		
		newEnt.setUploader(getUser(entry)); 
		return newEnt;
	}
	
	private User getUser(DocumentoDTO entry) {
		EntityFactory aux_factory = new UserFactory();
		return (User) aux_factory.createEntity(entry.getUploader());
	}

	private TipoDocumento getTipoDocumento(DocumentoDTO entry) {
		EntityFactory aux_factory = new TipoDocumentoFactory();
		return (TipoDocumento) aux_factory.createEntity(entry.getTipoDocumento());
	}

	private Origem getOrigem(DocumentoDTO entry) {
		EntityFactory aux_factory = new OrigemFactory();
		return (Origem) aux_factory.createEntity(entry.getOrigemDocumento());
	}

	private IdNumDocumento getIdNumDocumento(DocumentoDTO entry) {
		EntityFactory aux_factory = new IdNumDocumentoFactory();
		return (IdNumDocumento) aux_factory.createEntity(entry.getIdNumDocumento());
	}
	
	private PalavraChave getPalavraChave1(DocumentoDTO entry) {
		EntityFactory aux_factory = new PalavraChaveFactory();
		DTO check = entry.getPalavrasChaves1();
		if(check != null) return (PalavraChave) aux_factory.createEntity(check);
		else return null;
	}
	
	private PalavraChave getPalavraChave2(DocumentoDTO entry) {
		EntityFactory aux_factory = new PalavraChaveFactory();
		DTO check = entry.getPalavrasChaves2();
		if(check != null) return (PalavraChave) aux_factory.createEntity(check);
		else return null;
	}
	
	private PalavraChave getPalavraChave3(DocumentoDTO entry) {
		EntityFactory aux_factory = new PalavraChaveFactory();
		DTO check = entry.getPalavrasChaves3();
		if(check != null) return (PalavraChave) aux_factory.createEntity(check);
		else return null;
	}


}
