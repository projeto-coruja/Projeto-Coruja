package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.model.Documento;
import persistence.model.Entidade;
import persistence.model.IdNumDocumento;
import persistence.model.Origem;
import persistence.model.PalavraChave;
import persistence.model.TipoDocumento;
import persistence.model.User;

public class DocumentoUpdater implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Entidade updateEntity(DTO dto, Entidade ent) {
		DocumentoDTO entry = (DocumentoDTO) dto;
		
		((Documento) ent).setId(entry.getId());
		((Documento) ent).setOrigemDocumento(getOrigem(entry,ent));
		((Documento) ent).setIdentDocumento(getIdentDocumento(entry, ent));
		((Documento) ent).setTipoDocumento(getTipoDocumento(entry, ent));
		((Documento) ent).setAutor(entry.getAutor());
		((Documento) ent).setLocal(entry.getLocal());
		((Documento) ent).setDestinatario(entry.getDestinatario());
		((Documento) ent).setResumo(entry.getResumo());
		((Documento) ent).setDataDocumento(entry.getDataDocumento());
		((Documento) ent).setDataInclusao(entry.getDataInclusao());
		((Documento) ent).setUploader(getUser(entry, ent));
		((Documento) ent).setPalavrasChaves1(getPalavraChave1(entry, ent));
		((Documento) ent).setPalavrasChaves2(getPalavraChave2(entry, ent));
		((Documento) ent).setPalavrasChaves3(getPalavraChave3(entry, ent));
		
		return ent;
	}
	
	private User getUser(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new UserUpdater();
		return (User) aux_factory.updateEntity(entry.getUploader(), ((Documento) ent).getUploader());
	}

	private TipoDocumento getTipoDocumento(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new TipoDocumentoUpdater();
		return (TipoDocumento) aux_factory.updateEntity(entry.getTipoDocumento(), ((Documento) ent).getTipoDocumento());
	}

	private Origem getOrigem(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new OrigemUpdater();
		return (Origem) aux_factory.updateEntity(entry.getOrigemDocumento(), ((Documento) ent).getOrigemDocumento());
	}

	private IdNumDocumento getIdentDocumento(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new IdNumDocumentoUpdater();
		return (IdNumDocumento) aux_factory.updateEntity(entry.getIdNumDocumento(), ((Documento) ent).getIdNumDocumento());
	}
	
	private PalavraChave getPalavraChave1(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new PalavraChaveUpdater();
		DTO check = entry.getPalavrasChaves1();
		if(check != null) return (PalavraChave) aux_factory.updateEntity(check, ((Documento) ent).getPalavrasChaves1());
		else return null;	}
	
	private PalavraChave getPalavraChave2(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new PalavraChaveUpdater();
		DTO check = entry.getPalavrasChaves2();
		if(check != null) return (PalavraChave) aux_factory.updateEntity(check, ((Documento) ent).getPalavrasChaves2());
		else return null;	}
	
	private PalavraChave getPalavraChave3(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new PalavraChaveUpdater();
		DTO check = entry.getPalavrasChaves3();
		if(check != null) return (PalavraChave) aux_factory.updateEntity(check, ((Documento) ent).getPalavrasChaves3());
		else return null;
	}


}
