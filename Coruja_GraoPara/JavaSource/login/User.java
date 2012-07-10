package login;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	//--------------------------------------PASSWORD
	private String name;
	@ManyToOne
	@JoinColumn(name="id_profile", nullable=false)
	private Profile userprofile;
	
}
