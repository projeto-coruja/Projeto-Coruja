package Persistence.DTO;

public class UserDTO {

	private int id;

	private String nome;

	private String username;

	private String password;

	private ProfileDTO userProfile;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
