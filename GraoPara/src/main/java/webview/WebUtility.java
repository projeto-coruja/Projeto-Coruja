package webview;

import javax.servlet.http.Cookie;

import persistence.dto.ProfileDTO;

import business.EJB.userEJB.AuthBean;
import business.exceptions.login.UnreachableDataBaseException;

public final class WebUtility {
	
	public static String cookie_email = "email_graopara";
	public static String cookie_password = "senha_graopara";
	public static String cookie_nome = "nome_graopara";
	public static String cookie_status = "status_graopara";
	
	public static ProfileDTO admin_profile = new ProfileDTO("admin", true, true, true);
	public static ProfileDTO user_profile = new ProfileDTO("user", true, true, false);
	public static ProfileDTO default_profile = new ProfileDTO("default", false, true, false);
	
	public static int cookie_expire = -1; //1 sessão dias
	
	public static int cookieLogin(Cookie[] cookie_list) {
		if(cookie_list == null || cookie_list.length < 2) return AuthBean.LoginFail;
		
		String email = null;
		String password = null;
		for(int i = 0; i < cookie_list.length; i++) {
			Cookie cookie = cookie_list[i];
			String cName = cookie.getName();
			if(cName.equals(WebUtility.cookie_email))
				email = cookie.getValue();
			if(cName.equals(WebUtility.cookie_password))
				password = cookie.getValue();
		}
		if(email != null && password != null) {
			try {
				int result = AuthBean.validarLogin(email, password, AuthBean.HashedPwd);
				return result;
			} catch (UnreachableDataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return AuthBean.LoginFail;
			}
		}
		return AuthBean.LoginFail;
	}
	
	public static Cookie selectCookie(Cookie[] c_list, String c_name) {
		for(int i = 0; i < c_list.length; i++) {
			Cookie cookie = c_list[i];
			String cName = cookie.getName();
			if(cName.equals(c_name)) return cookie;
		}
		return null;
	}
	
	public static String strDiff(String str1, String str2) {
		int idx = str1.lastIndexOf(str2);
	    if (idx > -1) {
	      return str1.substring(str2.length());
	    }
	    else return str1;
	}

}
