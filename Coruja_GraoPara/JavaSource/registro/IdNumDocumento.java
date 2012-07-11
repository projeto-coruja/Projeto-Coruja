package registro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Determina informações sobre a numeração do documento

@Entity
@Table(name = "IdNumDocumento")
public class IdNumDocumento {
	
	//Indica se é APEP ou SEQ, por favor só utilizar esses valores
	@Id
	@Column(name = "tipoId")
	private String tipoId;
	

	//Respectivo código alfanumérico APEP ou sequencial
	@Id
	@Column(name = "codId")
	private String codId;
	
	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getCodOrigem() {
		return codId;
	}

	public void setCodOrigem(String codOrigem) {
		this.codId = codOrigem;
	}
	

}
