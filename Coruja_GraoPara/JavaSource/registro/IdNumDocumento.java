package registro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Determina informações sobre a numeração do documento

@Entity
@Table(name = "Id_Num_Documento")
public class IdNumDocumento implements Serializable{
	
	//Precisa ser serializável, então precisa ter
	private static final long serialVersionUID = 1L;

	//Indica se é APEP ou SEQ, por favor só utilizar esses valores
	@Id
	@Column(name = "tipo_Id", length = 5)
	private String tipoId;
	
	//Respectivo código alfanumérico APEP ou sequencial
	@Id
	@Column(name = "cod_Id", length = 7)
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
	

}
