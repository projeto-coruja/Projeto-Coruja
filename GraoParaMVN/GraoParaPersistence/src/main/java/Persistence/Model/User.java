package Persistence.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import Persistence.Utility.Password;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1115684572959901460L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	@Column(unique=true)
	private String email;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	@Column(name="data_inclusao")
	private Date dataInclusao;

	@ManyToOne
	@JoinColumn(name = "profile", nullable = false)
	private Profile userProfile;

	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	
	public String getPassword() {	return Password.getHash(password);	}
	public void setPassword(String password) {	this.password = Password.getHash(password);	}

	public String getName() {	return name;	}
	public void setName(String name) {	this.name = name;	}

	public Date getDataInclusao() {	return dataInclusao;}
	public void setDataInclusao(Date dataInclusao) {this.dataInclusao = dataInclusao;}
	
	public Profile getUserProfile() {	return userProfile;	}
	public void setUserProfile(Profile userProfile) {	this.userProfile = userProfile;	}

}