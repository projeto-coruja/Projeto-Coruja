package persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class TemaPalavraChaveMO implements EntityModel  {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String tema;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public String toString() {
		return tema;
	}

}
