package business.EJB.user;

public class UserBean {

	private String email;
	private String username;
	private String logType;

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return logType
	 */
	public String getLogType() {
		return logType;
	}

	/**
	 * 
	 * @param logType
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}

}
