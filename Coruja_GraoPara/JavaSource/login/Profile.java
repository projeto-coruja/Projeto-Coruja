package login;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {

	@Id
	@GeneratedValue
	private Integer id;
	private String profile;
	private Boolean write;
	private Boolean read;
	private Boolean edit;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getProfile() { return profile; }
	public void setProfile(String profile) { this.profile = profile; }
	
	public Boolean getWrite() {	 return write; }
	public void setWrite(Boolean write) { this.write = write; }
	
	public Boolean getRead() { return read;	}
	public void setRead(Boolean read) {	this.read = read; }
	
	public Boolean getEdit() { return edit; }
	public void setEdit(Boolean edit) { this.edit = edit; }
	
	
}
