package webview;

import java.io.Serializable;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("user_login")
@SessionScoped
public class UserLoginBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
