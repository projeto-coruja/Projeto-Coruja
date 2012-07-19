package Persistence.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Define informações sobre os tipos de documentos cadastros

@Entity
@Table(name="tbl_tipo_documento")
public class TipoDocumento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6734455580806452459L;
	//Define tipo de documento
	@Id
	@NotNull
	@Column(name = "tipo_documento", length = 20)
	private String tipoDocumento;

	public String getTipoDeDocumento() {
		return tipoDocumento;
	}
	public void setTipoDeDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}
