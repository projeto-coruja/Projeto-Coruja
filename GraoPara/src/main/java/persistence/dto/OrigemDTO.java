package persistence.dto;

public class OrigemDTO implements DTO {

	private Long id;
	private String codOrigem;
	private String tipoOrigem;
	private String titulo;
	
	public OrigemDTO(){}

	public OrigemDTO(String codOrigem, String tipoOrigem, String titulo) {
		super();
		this.codOrigem = codOrigem;
		this.tipoOrigem = tipoOrigem;
		this.titulo = titulo;
	}
	
	public String getCodOrigem() {	return codOrigem;	}
	public void setCodOrigem(String codOrigem) {	this.codOrigem = codOrigem;	}

	public String getTipoOrigem() {	return tipoOrigem;	}
	public void setTipoOrigem(String tipoOrigem) {	this.tipoOrigem = tipoOrigem;	}

	public String getTitulo() {	return titulo;	}
	public void setTitulo(String titulo) {	this.titulo = titulo;	}

	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}

}
