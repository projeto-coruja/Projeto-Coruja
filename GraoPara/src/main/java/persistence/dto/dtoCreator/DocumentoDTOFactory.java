package persistence.dto.dtoCreator;

import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import persistence.model.Documento;
import persistence.model.Entidade;

public class DocumentoDTOFactory implements DTOFactory {


	/**
	 * @see persistence.dto.dtoCreator.DTOFactory#createDTO(Object)
	 * 
	 *  
	 */
	public DocumentoDTO createDTO(Entidade entity) {
		Documento entry = (Documento) entity;
		DocumentoDTO newDTO = new DocumentoDTO(entry.getId(), getOrigemDTO(entry), getIdNumDocumentoDTO(entry), getTipoDocumentoDTO(entry),
				entry.getAutor(), entry.getLocal(), entry.getDestinatario(), entry.getResumo(), entry.getDataDocumento(),
				entry.getDataInclusao(), getUserDTO(entry), getPalavraChave1(entry), getPalavraChave2(entry), getPalavraChave3(entry));
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
	
	private PalavraChaveDTO getPalavraChave1(Documento entry) {
		DTOFactory aux_factory = new PalavraChaveDTOFactory();
		return (PalavraChaveDTO) aux_factory.createDTO(entry.getPalavrasChaves1());
	}
	
	private PalavraChaveDTO getPalavraChave2(Documento entry) {
		DTOFactory aux_factory = new PalavraChaveDTOFactory();
		return (PalavraChaveDTO) aux_factory.createDTO(entry.getPalavrasChaves2());
	}
	
	private PalavraChaveDTO getPalavraChave3(Documento entry) {
		DTOFactory aux_factory = new PalavraChaveDTOFactory();
		return (PalavraChaveDTO) aux_factory.createDTO(entry.getPalavrasChaves3());
	}
}
