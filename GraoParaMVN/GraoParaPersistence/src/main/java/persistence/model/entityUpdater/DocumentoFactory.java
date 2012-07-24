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

public class DocumentoFactory implements EntityUpdate {


	/**
	 * @see persistence.model.entityCreator.EntityFactory#createEntity(Object)
	 */
	public Documento updateEntity(DTO dto, Entidade ent) {
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
		newEnt.setPalChaves(getPalavraChave(entry));		
		newEnt.setUploader(getUser(entry)); 
		return newEnt;
	}
	
	private User getUser(DocumentoDTO entry) {
		EntityUpdate aux_factory = new UserUpdater();
		return (User) aux_factory.updateEntity(entry.getUploader(), null);
	}

	private TipoDocumento getTipoDocumento(DocumentoDTO entry) {
		EntityUpdate aux_factory = new TipoDocumentoFactory();
		return (TipoDocumento) aux_factory.updateEntity(entry.getTipoDocumento(), null);
	}

	private Origem getOrigem(DocumentoDTO entry) {
		EntityUpdate aux_factory = new OrigemFactory();
		return (Origem) aux_factory.updateEntity(entry.getOrigemDocumento(), null);
	}

	private IdNumDocumento getIdNumDocumento(DocumentoDTO entry) {
		EntityUpdate aux_factory = new IdNumDocumentoFactory();
		return (IdNumDocumento) aux_factory.updateEntity(entry.getIdNumDocumento(), null);
	}
	
	private PalavraChave[] getPalavraChave(DocumentoDTO entry) {
		EntityUpdate aux_factory = new PalavraChaveFactory();
		PalavraChaveDTO[] list = entry.getPalChaves();
		int length = list.length;
		PalavraChave[] palchaves = new PalavraChave[length];
		for(int i = 0; i < length; i++)
		{
			palchaves[i] = (PalavraChave) aux_factory.updateEntity(list[i], null);
		}
		return palchaves;
	}


}
