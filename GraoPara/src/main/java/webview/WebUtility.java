package webview;

import javax.servlet.http.Cookie;

import business.EJB.AuthBean;
import business.exceptions.UnreachableDataBaseException;

public final class WebUtility {
	
	public static String cookie_email = "email_graopara";
	public static String cookie_password = "senha_graopara";
	public static String session_logged = "isLogged";
	
	public static int cookie_expire = (60 * 60 * 24) * 100; //100 dias
	
	public static boolean cookieLogin(Cookie[] cookie_list) {
		if(cookie_list == null || cookie_list.length < 2) return false;
		
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
				if(AuthBean.validarLogin(email, password, AuthBean.HashedPwd)) {
					return true;
				}
				else {
					return false;
				}
			} catch (UnreachableDataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

}
