package webview.filters;

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

import webview.WebUtility;

import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.UserBean;

/**
 * Servlet Filter implementation class DefaultFilter
 */
@WebFilter("/")
public class StartFilter implements Filter {
	
	private static final Log log = LogFactory.getLog(StartFilter.class);

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
		log.info("Entrei");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie[] c_list = req.getCookies();
		Cookie c_status = WebUtility.selectCookie(c_list, WebUtility.cookie_status);
		if(c_status != null && Integer.parseInt(c_status.getValue()) == AuthBean.LoginFailOrDefault) {
			res.sendRedirect(req.getContextPath() + "/public/index.jsp");
		}
		else if(c_status != null && Integer.parseInt(c_status.getValue()) == AuthBean.LoginSuccessUser) {
			res.sendRedirect(req.getContextPath() + "/protected/user/indexUser.jsp");
		}
		else if(c_status != null && Integer.parseInt(c_status.getValue()) == AuthBean.LoginSuccessAdmin) {
			res.sendRedirect(req.getContextPath() + "/protected/admin/indexAdmin.jsp");
		}
		else {
			UserBean user = WebUtility.cookieLogin(c_list);			
			if(user == null)
			{
				res.sendRedirect(req.getContextPath() + "/public");
			}
			else if(user.getLogType() == AuthBean.LoginFailOrDefault) {
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.addCookie(c_status);
				res.sendRedirect(req.getContextPath() + "/public/index.jsp");
			}
			else if(user.getLogType() == AuthBean.LoginSuccessUser){
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.sendRedirect(req.getContextPath() + "/protected/user/indexUser.jsp");
			}
			else if(user.getLogType() == AuthBean.LoginSuccessAdmin){
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.sendRedirect(req.getContextPath() + "/protected/admin/indexAdmin.jsp");
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
