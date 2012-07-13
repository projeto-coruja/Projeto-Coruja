package registro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Define informações sobre os tipos de documentos cadastros

@Entity
@Table(name="Tipo_Documento")
public class TipoDocumento {
	
	
	//Define tipo de documento
	@Id
	@NotNull
	@Column(name = "tipo_De_Documento", length = 20)
	private String tipoDeDocumento;
	
	public String getTipoDeDocumento() {
		return tipoDeDocumento;
	}
	public void setTipoDeDocumento(String tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}
	
}
