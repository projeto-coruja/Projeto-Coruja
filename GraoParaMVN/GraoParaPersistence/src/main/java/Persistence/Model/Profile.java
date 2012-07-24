package Persistence.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_profile")
public class Profile implements Serializable,Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5301660648516466020L;

	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@NotEmpty
	@Column(unique=true)
	private String profile;

	@NotNull
	@NotEmpty
	private Boolean write;

	@NotNull
	@NotEmpty
	private Boolean read;

	@NotNull
	@NotEmpty
	private Boolean edit;

	public Integer getId() {	return id;	}
	public void setId(Integer id) {	this.id = id;	}

	public String getProfile() {	return profile;	}
	public void setProfile(String profile) {	this.profile = profile;	}

	public Boolean getWrite() {	return write;	}
	public void setWrite(Boolean write) {	this.write = write;	}

	public Boolean getRead() {	return read;	}
	public void setRead(Boolean read) {	this.read = read;	}

	public Boolean getEdit() {	return edit;	}
	public void setEdit(Boolean edit) {	this.edit = edit;	}

}