package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



//Determina informações sobre a numeração do documento

@Entity
//@Indexed
@Table(name = "tbl_id_num_documento")
public class IdNumDocumento implements Serializable,Entidade {

	// Precisa ser serializável, então precisa ter
	private static final long serialVersionUID = -4847594347591942450L;

	@Id
	@GeneratedValue
	private Long id;

	// Indica se é APEP ou SEQ, por favor só utilizar esses valores
	@Column(name = "tipo_id", length = 5)
	private String tipoId;

	// Respectivo código alfanumérico APEP ou sequencial
	//@Field(analyze=Analyze.NO)
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