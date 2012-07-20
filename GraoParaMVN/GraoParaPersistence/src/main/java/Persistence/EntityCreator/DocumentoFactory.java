package Persistence.EntityCreator;

import Persistence.DTO.DocumentoDTO;
import Persistence.DTO.PalavraChaveDTO;
import Persistence.Model.Documento;
import Persistence.Model.IdNumDocumento;
import Persistence.Model.Origem;
import Persistence.Model.PalavraChave;
import Persistence.Model.TipoDocumento;
import Persistence.Model.User;

public class DocumentoFactory implements EntityFactory {


	/**
	 * @see Persistence.EntityCreator.EntityFactory#createEntity(Object)
	 */
	public Documento createEntity(Object dto) {
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
	
	private PalavraChave[] getPalavraChave(DocumentoDTO entry) {
		EntityFactory aux_factory = new PalavraChaveFactory();
		PalavraChaveDTO[] list = entry.getPalChaves();
		int length = list.length;
		PalavraChave[] palchaves = new PalavraChave[length];
		for(int i = 0; i < length; i++)
		{
			palchaves[i] = (PalavraChave) aux_factory.createEntity(list[i]);
		}
		return palchaves;
	}


}
