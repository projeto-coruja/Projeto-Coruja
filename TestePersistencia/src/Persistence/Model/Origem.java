package Persistence.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Determina informações sobre a origem do documento

@Entity
@Table(name = "Origem")
public class Origem {
	
	//Indica se é CAIXA ou CODICE, por favor só utilizar esses valores
	@NotNull
	@Column(name = "tipo_Origem", length = 7)
	private String tipoOrigem;
	
	//Código alfanumérico da respectiva caixa ou códice
	@Id
	@Column(name = "cod_Origem", length = 7)
	private String codOrigem;
	
	//Título do códice
	@NotNull
	@Column(name = "titulo")
	private String titulo;

	public String getTipoOrigem() {
		return tipoOrigem;
	}

	public void setTipoOrigem(String tipoOrigem) {
		this.tipoOrigem = tipoOrigem;
	}

	public String getCodOrigem() {
		return codOrigem;
	}

	public void setCodOrigem(String codOrigem) {
		this.codOrigem = codOrigem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
