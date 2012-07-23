package Persistence.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Determina informações sobre a origem do documento

@Entity
@Table(name = "tbl_origem")
public class Origem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1402222946640969560L;

	@Id
	@GeneratedValue
	private Integer id;

	// Código alfanumérico da respectiva caixa ou códice
	@Column(name = "cod_origem", length = 7)
	private String codOrigem;

	// Indica se é CAIXA ou CODICE, por favor só utilizar esses valores
	@NotNull
	@Column(name = "tipo_origem", length = 7)
	private String tipoOrigem;

	// Título do códice
	@NotNull
	@Column(name = "titulo")
	private String titulo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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