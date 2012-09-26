package persistence.dto;

public class TemaPalavraChave implements DTO{
	
	private Long id;

	private String tema;	//Atores, Instituição, Ação
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
}
