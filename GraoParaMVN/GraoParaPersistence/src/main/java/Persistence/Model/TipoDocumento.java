package Persistence.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Define informações sobre os tipos de documentos cadastros

@Entity
@Table(name="tbl_tipo_documento")
public class TipoDocumento implements Serializable,Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6734455580806452459L;

	@Id
	@GeneratedValue
	private Integer id;
	
	//Define tipo de documento
	@NotNull
	@Column(name = "tipo_documento", length = 20)
	private String tipoDocumento;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}
