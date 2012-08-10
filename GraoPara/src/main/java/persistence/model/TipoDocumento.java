package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Define informações sobre os tipos de documentos cadastros

@Entity
//@Indexed
@Table(name="tbl_tipo_documento")
public class TipoDocumento implements Serializable,Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6734455580806452459L;

	@Id
	@GeneratedValue
	private Long id;
	
	//Define tipo de documento
	//@Field(analyze=Analyze.NO)
	@NotNull
	@Column(name = "tipo_documento", length = 20)
	private String tipoDocumento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}
