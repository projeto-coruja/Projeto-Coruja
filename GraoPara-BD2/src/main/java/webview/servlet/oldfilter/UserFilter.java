package webview.servlet.oldfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.JavascriptAlerts;
import webview.util.WebUtility;
import business.EJB.user.AuthBean;
import business.EJB.user.UserBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/protected/user/*")
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie[] c_list = req.getCookies();
		Cookie c_status = WebUtility.selectCookie(c_list, WebUtility.cookie_status);
		if(c_status != null && c_status.getValue().equals(AuthBean.LoginSuccessUserLevel2)) {
			chain.doFilter(request, response);
		}
		else if(c_status != null && c_status.getValue().equals(AuthBean.LoginSuccessAdmin)) {
			res.sendRedirect(req.getContextPath() + "/protected/admin/index.jsp");
		}
		else if(c_status != null && c_status.getValue().equals(AuthBean.LoginFailOrDefault)) {
		    
		    JavascriptAlerts.alertAndRedirectPage(res, "Você não possuí permissão para acessar esta área!", "/GraoPara/public/index.jsp");
		    
			chain.doFilter(request, response);
		}
		else {
			UserBean user = WebUtility.cookieLogin(c_list);			
			if(user != null && user.getLogType() == AuthBean.LoginSuccessUserLevel2) {
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.addCookie(c_status);
				chain.doFilter(request, response);
			}
			else if(user != null && user.getLogType() == AuthBean.LoginSuccessAdmin) {
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.sendRedirect(req.getContextPath() + "/protected/admin/index.jsp");
			}
			else {
				
				JavascriptAlerts.alertAndRedirectPage(res, "Você não possuí permissão para acessar esta área!", "/GraoPara/public/index.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
