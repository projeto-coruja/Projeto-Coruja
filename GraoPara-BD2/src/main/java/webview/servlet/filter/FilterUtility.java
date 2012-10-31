package webview.servlet.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.AlertsUtility;
import webview.util.WebUtility;

import business.EJB.user.AuthBean;
import business.EJB.user.UserBean;

public class FilterUtility {

	private static class Tuple {
		private final String fst;
		private final String snd;
		
		public Tuple(String fst, String snd) {
			this.fst = fst;
			this.snd = snd;
		}
	}
	
	private static HashMap<String, Tuple> redirMap = new HashMap<String, Tuple>();
	static {
		redirMap.put(AuthBean.LoginFailOrDefault, 
				new Tuple("Acesso negado: você não está logado ou seu cadastro não foi validado.", "/GraoPara/public/index.jsp"));
		redirMap.put(AuthBean.LoginSuccessUserLevel1, 
				new Tuple("Acesso negado: você não pode acessar esta área como usuário de nível 1.", "/GraoPara/protected/user/index.jsp"));
		redirMap.put(AuthBean.LoginSuccessUserLevel2, 
				new Tuple("Acesso negado: você não pode acessar esta área como usuário de nível 2.", "/GraoPara/protected/userAdv/index.jsp"));
		//OK, esse não tem motivo de existir;
		redirMap.put(AuthBean.LoginSuccessAdmin, 
				new Tuple("Acesso negado: você não pode acessar essa área como admin.", "/GraoPara/protected/admin/index.jsp"));	
	}
	
	public static void blockAndRedirect(HttpServletResponse res, String c_value) throws IOException {
		Tuple selected = redirMap.get(c_value);
		AlertsUtility.alertAndRedirectPage(res, selected.fst, selected.snd);
	}
	
	public static void trueFilter(String authLevel, ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie[] c_list = req.getCookies();
		Cookie c_status = WebUtility.selectCookie(c_list, WebUtility.cookie_status);
		if(c_status != null) {
			String c_value = c_status.getValue();
			if(c_value.equals(authLevel)) {
				chain.doFilter(request, response);
			} 
			else FilterUtility.blockAndRedirect(res, c_value);
		} 
		else {
			UserBean user = WebUtility.cookieLogin(c_list);
			if(user != null) {
				String u_value = user.getLogType();
				if(u_value.equals(authLevel)) {
					c_status = new Cookie(WebUtility.cookie_status, u_value);
					c_status.setMaxAge(-1);
					res.addCookie(c_status);
					chain.doFilter(request, response);
				}
				else FilterUtility.blockAndRedirect(res, u_value);
			}
			else FilterUtility.blockAndRedirect(res, AuthBean.LoginFailOrDefault);
		}
	}
	

}
