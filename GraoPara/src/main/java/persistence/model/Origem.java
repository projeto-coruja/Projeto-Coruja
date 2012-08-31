package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

//Determina informações sobre a origem do documento

@Entity
//@Indexed
@Table(name = "tbl_origem", uniqueConstraints=@UniqueConstraint(columnNames = {"cod_origem", "tipo_origem"}))
public class Origem implements Serializable,Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1402222946640969560L;

	@Id
	@GeneratedValue
	private Long id;

	// Código alfanumérico da respectiva caixa ou códice
	//@Field(analyze=Analyze.NO)
	@NotEmpty
	@NotNull
	@Column(name = "cod_origem", length = 7)
	private String codOrigem;

	// Indica se é CAIXA ou CODICE, por favor só utilizar esses valores
	//@Field(analyze=Analyze.NO)
	@NotEmpty
	@NotNull
	@Column(name = "tipo_origem", length = 7)
	private String tipoOrigem;

	// Título do códice
	//@Field
	@NotNull
	@Column(name = "titulo")
	private String titulo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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