package Persistence.DTO;

public class UserDTO {

	private Long id;

	private String name;

	private String username;

	private String password;

	private ProfileDTO userProfile;
	
	private String email;

	public long getId() {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileDTO getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(ProfileDTO userProfile) {
		this.userProfile = userProfile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
