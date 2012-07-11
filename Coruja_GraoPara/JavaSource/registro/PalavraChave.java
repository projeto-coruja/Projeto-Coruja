package registro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PalavraChave")
public class PalavraChave {
	
	//Define identificação de uso interno
	@Id
	@GeneratedValue
	private Integer id;
	
	//Define palavra-chave
	@NotNull
	@Column(name = "palavra", unique = true)
	private String palavra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}


}
