package persistence.dto;

public class IdNumDocumentoDTO implements DTO {
	
	private Long id;

	private String tipoId;

	private String codId;

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getCodId() {
		return codId;
	}

	public void setCodId(String codId) {
		this.codId = codId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
