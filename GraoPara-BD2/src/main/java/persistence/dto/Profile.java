package persistence.dto;

public class Profile implements DTO {
	
	private Long id;
	
	private String profile;

	public Profile(String profile) {
		this.profile = profile;
	}
	
	public Profile() {
		//JDTO
	}

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
