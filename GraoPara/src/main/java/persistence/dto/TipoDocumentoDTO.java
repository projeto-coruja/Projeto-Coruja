package persistence.dto;

public class TipoDocumentoDTO implements DTO {
	
	private Long id;
	private String tipoDocumento;

	public TipoDocumentoDTO(){}
	
	public TipoDocumentoDTO(String tipoDocumento) {
		super();
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoDocumento() {	return tipoDocumento;	}
	public void setTipoDocumento(String tipoDocumento) {	this.tipoDocumento = tipoDocumento;	}

	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}

}
