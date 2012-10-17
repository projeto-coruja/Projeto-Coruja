package persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProfileMO implements EntityModel  {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NaturalId
	@NotEmpty
	private String profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
