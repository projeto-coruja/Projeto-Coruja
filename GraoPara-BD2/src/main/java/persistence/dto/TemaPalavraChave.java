package persistence.dto;

public class TemaPalavraChave {
	
	private int id;

	private String tema;	//Atores, Instituição, Ação
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
