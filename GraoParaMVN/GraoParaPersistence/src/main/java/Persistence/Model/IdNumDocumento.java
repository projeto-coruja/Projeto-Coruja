package Persistence.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Determina informações sobre a numeração do documento

@Entity
@Table(name = "tbl_id_num_documento")
public class IdNumDocumento implements Serializable{

	//Precisa ser serializável, então precisa ter
	private static final long serialVersionUID = -4847594347591942450L;

	//Indica se é APEP ou SEQ, por favor só utilizar esses valores
	@Id
	@Column(name = "tipo_id", length = 5)
	private String tipoId;

	//Respectivo código alfanumérico APEP ou sequencial
	@Id
	@Column(name = "cod_id", length = 7)
	private String codId;

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getCodId() {
		return codId;
	}

	public void setCodOrigem(String codId) {
		this.codId = codId;
	}

	@Override
	public boolean equals(Object outro) {
		if(this == outro) return true;

		if(!(outro instanceof IdNumDocumento)) return false;

		final IdNumDocumento comp = (IdNumDocumento) outro;
		if(!(comp.getCodId().equals(getCodId()))) return false;
		if(!(comp.getTipoId().equals(getTipoId()))) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result = getTipoId().hashCode();
		result = result*29 + getCodId().hashCode();
		return result;
	}


}