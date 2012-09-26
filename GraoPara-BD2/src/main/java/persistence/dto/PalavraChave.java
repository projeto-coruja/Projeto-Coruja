package persistence.dto;

import org.jdto.annotation.DTOCascade;


public class PalavraChave implements DTO {
	
	private Long id;
	
	@DTOCascade
	private TemaPalavraChave tema;
	
	private String palavra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TemaPalavraChave getTema() {
		return tema;
	}

	public void setTema(TemaPalavraChave tema) {
		this.tema = tema;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

}
