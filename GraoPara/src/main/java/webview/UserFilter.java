package webview;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.AuthBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/pages/protected/user/*")
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
		int logType = (Integer) req.getSession().getAttribute(WebUtility.session_logged);
		if(logType > AuthBean.LoginFail) {
			chain.doFilter(request, response);
		}
		else {
			logType = WebUtility.cookieLogin(req.getCookies());
			if(logType > AuthBean.LoginFail) {
				req.setAttribute(WebUtility.session_logged, logType);
				chain.doFilter(request, response);
			}
			else {
				HttpServletResponse res = (HttpServletResponse) response;
				res.sendRedirect(req.getContextPath() + "/pages/public/Error.jsp");
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
