package persistence.dto;

public class ProfileDTO implements DTO {

	private Long id;
	
	private String profile;

	private boolean write;

	private boolean read;

	private boolean edit;
	
	public ProfileDTO() {}

	public ProfileDTO(String profile, boolean write, boolean read, boolean edit) {
		super();
		this.profile = profile;
		this.write = write;
		this.read = read;
		this.edit = edit;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
