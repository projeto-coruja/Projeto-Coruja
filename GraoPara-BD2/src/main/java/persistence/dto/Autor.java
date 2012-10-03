package persistence.dto;

public class Autor implements DTO {
	
	private Long id;
	
	private String nome;
	
	private String ocupacao;

	public Autor() {
		//JDTO
	}
	
	public Autor(String nome, String ocupacao) {
		this.nome = nome;
		this.ocupacao = ocupacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

}
