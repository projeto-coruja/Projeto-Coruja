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

//Determina informações sobre a numeração do documento

@Entity
//@Indexed
@Table(name = "tbl_id_num_documento", uniqueConstraints=@UniqueConstraint(columnNames = {"tipo_id", "cod_id"}))
public class IdNumDocumento implements Serializable,Entidade {

	// Precisa ser serializável, então precisa ter
	private static final long serialVersionUID = -4847594347591942450L;

	@Id
	@GeneratedValue
	private Long id;

	// Indica se é APEP ou SEQ, por favor só utilizar esses valores
	@NotEmpty
	@NotNull
	@Column(name = "tipo_id", length = 5)
	private String tipoId;

	// Respectivo código alfanumérico APEP ou sequencial
	//@Field(analyze=Analyze.NO)
	@NotEmpty
	@NotNull
	@Column(name = "cod_id", length = 7)
	private String codId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

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

}