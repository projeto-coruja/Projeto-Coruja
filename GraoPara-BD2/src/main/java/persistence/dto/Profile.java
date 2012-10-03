package persistence.dto;

public class Profile implements DTO {
	
	private Long id;
	
	private String name;

	public Profile(String profile) {
		this.name = profile;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
