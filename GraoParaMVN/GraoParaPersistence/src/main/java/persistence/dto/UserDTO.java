package persistence.dto;

import java.util.Date;

public class UserDTO implements DTO {

	private Long id;
	
	private String name;

	private String password;

	private ProfileDTO userProfile;
	
	private String email;
	
	private Date dataInclusao;
	
	public UserDTO() {}

	public UserDTO(String name, String password, ProfileDTO userProfile,
			String email, Date dataInclusao) {
		super();
		this.name = name;
		this.password = password;
		this.userProfile = userProfile;
		this.email = email;
		this.dataInclusao = dataInclusao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
