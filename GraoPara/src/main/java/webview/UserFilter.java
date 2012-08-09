package webview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.userEJB.AuthBean;

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
		Integer logType = (Integer) req.getSession().getAttribute(WebUtility.session_logged);
		if(logType != null && logType > AuthBean.LoginFail) {
			chain.doFilter(request, response);
		}
		else {
			logType = WebUtility.cookieLogin(req.getCookies());
			if(logType != null && logType > AuthBean.LoginFail) {
				req.setAttribute(WebUtility.session_logged, logType);
				chain.doFilter(request, response);
			}
			else {
				HttpServletResponse res = (HttpServletResponse) response;
				res.setContentType("text/html");  
			    PrintWriter out=res.getWriter();   
				out.println("<script>");  
			    out.println("alert('Você não possuí permissão para acessar esta área!');");  
			    out.println("document.location=('/GraoPara/');");  
			    out.println("</script>");
				//res.sendRedirect(req.getContextPath() + "/faces/pages/public/index.jsp");
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
