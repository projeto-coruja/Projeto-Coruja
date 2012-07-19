package Persistence.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_palavra_chave")
public class PalavraChave implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6491771728555015270L;
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "palavra", unique = true, length = 30)
	private String palavra;

	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	
	public String getPalavra() {	return palavra;	}
	public void setPalavra(String palavra) {	this.palavra = palavra;	}


}