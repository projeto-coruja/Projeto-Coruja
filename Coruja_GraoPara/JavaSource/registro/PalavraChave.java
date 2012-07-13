package registro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Palavra_Chave")
public class PalavraChave {
		
	//Define palavra-chave
	@Id
	@NotNull
	@Column(name = "palavra", unique = true, length = 30)
	private String palavra;

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}


}
