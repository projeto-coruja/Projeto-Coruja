package registro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Define informações sobre os tipos de documentos cadastros

@Entity
@Table(name="Documentos")
public class TipoDocumento {
	
	//Define identificação de uso interno
	@Id
	@GeneratedValue
	private Integer id;
	
	//Define tipo de documento
	@NotNull
	@Column(name = "tipoDeDocumento", unique = true)
	private String tipoDeDocumento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoDeDocumento() {
		return tipoDeDocumento;
	}
	public void setTipoDeDocumento(String tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}
	
}
