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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import webview.util.WebUtility;
import business.EJB.user.AuthBean;
import business.EJB.user.UserBean;

/**
 * Servlet Filter implementation class DefaultFilter
 */
//@WebFilter("/")
public class StartFilter implements Filter {

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(StartFilter.class);

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
    /**
     * Default constructor. 
     */
    public StartFilter() {
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
		Cookie c_email = WebUtility.selectCookie(c_list, WebUtility.cookie_email);
		Cookie c_username = WebUtility.selectCookie(c_list, WebUtility.cookie_nome);
		Cookie c_session = WebUtility.selectCookie(c_list, WebUtility.cookie_session);
		
		if(c_status != null && (c_status.getValue().equals(AuthBean.LoginFailOrDefault))) {
			res.sendRedirect(req.getContextPath() + "/public/index.jsp");
		}
		
		else if(c_status != null && (c_status.getValue().equals(AuthBean.LoginSuccessUserLevel2) 
				&& AuthBean.allowOperation(c_session.getValue(), c_email.getValue(), c_username.getValue(), c_status.getValue()))) {
			res.sendRedirect(req.getContextPath() + "/protected/user/index.jsp");
		}
		else if(c_status != null && (c_status.getValue().equals(AuthBean.LoginSuccessAdmin))) {
			res.sendRedirect(req.getContextPath() + "/protected/admin/index.jsp");
		}
		else {
			UserBean user = WebUtility.cookieLogin(c_list);			
			
			if(user == null){
				res.sendRedirect(req.getContextPath() + "/public/index.jsp");
			}
			else if(user.getLogType().equals(AuthBean.LoginFailOrDefault)) {
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.addCookie(c_status);
				res.sendRedirect(req.getContextPath() + "/public/index.jsp");
			}
			else if(user.getLogType().equals(AuthBean.LoginSuccessUserLevel2)){
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.sendRedirect(req.getContextPath() + "/protected/user/index.jsp");
			}
			else if(user.getLogType().equals(AuthBean.LoginSuccessAdmin)){
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.sendRedirect(req.getContextPath() + "/protected/admin/index.jsp");
			}
		}
	}

}
