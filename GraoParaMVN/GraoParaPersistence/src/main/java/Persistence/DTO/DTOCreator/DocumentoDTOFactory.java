package Persistence.DTO.DTOCreator;

import Persistence.DTO.DocumentoDTO;
import Persistence.DTO.IdNumDocumentoDTO;
import Persistence.DTO.OrigemDTO;
import Persistence.DTO.PalavraChaveDTO;
import Persistence.DTO.TipoDocumentoDTO;
import Persistence.DTO.UserDTO;
import Persistence.Model.Documento;
import Persistence.Model.PalavraChave;

public class DocumentoDTOFactory implements DTOFactory {


	/**
	 * @see Persistence.DTO.DTOCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public DocumentoDTO createDTO(Object entity) {
		DocumentoDTO newDTO = new DocumentoDTO();
		Documento entry = (Documento) entity;
		
		newDTO.setOrigemDocumento(getOrigemDTO(entry));
		newDTO.setIdNumDocumento(getIdNumDocumentoDTO(entry));
		newDTO.setTipoDocumento(getTipoDocumentoDTO(entry));
		newDTO.setAutor(entry.getAutor());
		newDTO.setDestinatario(entry.getDestinatario());
		newDTO.setLocal(entry.getLocal());
		newDTO.setResumo(entry.getResumo());
		newDTO.setDataInclusao(entry.getDataInclusao());
		newDTO.setDataDocumento(entry.getDataDocumento());
		newDTO.setPalChaves(getPalavraChaveDTO(entry));		
		newDTO.setUploader(getUserDTO(entry)); 
		return newDTO;
	}
	
	private UserDTO getUserDTO(Documento entry) {
		DTOFactory aux_factory = new UserDTOFactory();
		return (UserDTO) aux_factory.createDTO(entry.getUploader());
	}

	private TipoDocumentoDTO getTipoDocumentoDTO(Documento entry) {
		DTOFactory aux_factory = new TipoDocumentoDTOFactory();
		return (TipoDocumentoDTO) aux_factory.createDTO(entry.getTipoDocumento());
	}

	private OrigemDTO getOrigemDTO(Documento entry) {
		DTOFactory aux_factory = new OrigemDTOFactory();
		return (OrigemDTO) aux_factory.createDTO(entry.getOrigemDocumento());
	}

	private IdNumDocumentoDTO getIdNumDocumentoDTO(Documento entry) {
		DTOFactory aux_factory = new IdNumDocumentoDTOFactory();
		return (IdNumDocumentoDTO) aux_factory.createDTO(entry.getIdNumDocumento());
	}
	
	private PalavraChaveDTO[] getPalavraChaveDTO(Documento entry) {
		DTOFactory aux_factory = new PalavraChaveDTOFactory();
		PalavraChave[] list = entry.getPalChaves();
		int length = list.length;
		PalavraChaveDTO[] palchaves = new PalavraChaveDTO[length];
		for(int i = 0; i < length; i++)
		{
			palchaves[i] = (PalavraChaveDTO) aux_factory.createDTO(list[i]);
		}
		return palchaves;
	}
}
