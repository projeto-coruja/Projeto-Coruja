package persistence.model.entityUpdater;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.dto.PalavraChaveDTO;
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
		((Documento) ent).setPalChaves(getPalavraChave(entry, ent));
		
		return ent;
	}
	
	private User getUser(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new UserUpdater();
		return (User) aux_factory.updateEntity(entry.getUploader(), null);
	}

	private TipoDocumento getTipoDocumento(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new TipoDocumentoUpdater();
		return (TipoDocumento) aux_factory.updateEntity(entry.getTipoDocumento(), null);
	}

	private Origem getOrigem(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new OrigemUpdater();
		return (Origem) aux_factory.updateEntity(entry.getOrigemDocumento(), null);
	}

	private IdNumDocumento getIdentDocumento(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new IdNumDocumentoUpdater();
		return (IdNumDocumento) aux_factory.updateEntity(entry.getIdNumDocumento(), null);
	}
	
	private PalavraChave[] getPalavraChave(DocumentoDTO entry, Entidade ent) {
		EntityUpdate aux_factory = new PalavraChaveUpdater();
		PalavraChaveDTO[] list = entry.getPalavrasChaves();
		int length = list.length;
		PalavraChave[] palchaves = new PalavraChave[length];
		for(int i = 0; i < length; i++)
		{
			palchaves[i] = (PalavraChave) aux_factory.updateEntity(list[i], null);
		}
		return palchaves;
	}


}
