package persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProfileMO implements EntityMO  {
	
	@Id
	private Long id;
	
	@NaturalId
	@NotEmpty
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
