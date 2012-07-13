package login;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="login_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@ManyToOne
	@JoinColumn(name="profile", nullable=false)
	private Profile userProfile;
	
	public Integer getId() {return id;}
	public void setId(Integer id) {	this.id = id;}
	
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	
	public String getPassword() {return Password.getHash(password);}
	public void setPassword(String passsword) {this.password = Password.getHash(password);}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public Profile getUserProfile() {return userProfile;}
	public void setUserProfile(Profile userProfile) {this.userProfile = userProfile;}
	
}