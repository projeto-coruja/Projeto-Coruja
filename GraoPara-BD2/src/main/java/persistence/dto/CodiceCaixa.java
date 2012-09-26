package persistence.dto;

public class CodiceCaixa implements DTO {
	
	private Long id;
	
	private String cod;
	
	private String titulo;
	
	private int anoInicio;
	
	private int anoFim;

	public CodiceCaixa(String cod, String titulo, int anoInicio, int anoFim) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.anoInicio = anoInicio;
		this.anoFim = anoFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}
	
	public int getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

}
