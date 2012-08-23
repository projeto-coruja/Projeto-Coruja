package webview.filters;

import java.io.IOException;
import java.io.PrintWriter;

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

import webview.WebUtility;

import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.UserBean;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/protected/admin/*")
public class AdminFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public AdminFilter() {
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
		if(c_status != null && Integer.parseInt(c_status.getValue()) == AuthBean.LoginSuccessAdmin) {
			chain.doFilter(request, response);
		}
		else if(c_status != null && Integer.parseInt(c_status.getValue()) == AuthBean.LoginSuccessUser) {
			res.setContentType("text/html");  
		    PrintWriter out=res.getWriter();   
			out.println("<script>");  
		    out.println("alert('Você não possuí permissão para acessar esta área!');");  
		    out.println("document.location=('/GraoPara/protected/user/indexUser.jsp');");  
		    out.println("</script>");
		}
		else if(c_status != null && Integer.parseInt(c_status.getValue()) == AuthBean.LoginFailOrDefault) {
			res.setContentType("text/html");  
		    PrintWriter out=res.getWriter();   
			out.println("<script>");  
		    out.println("alert('Você não possuí permissão para acessar esta área!');");  
		    out.println("document.location=('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
		}
		else {
			UserBean user = WebUtility.cookieLogin(c_list);			
			if(user != null && user.getLogType() == AuthBean.LoginSuccessAdmin) {
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.addCookie(c_status);
				chain.doFilter(request, response);
			}
			else if(user != null && user.getLogType() == AuthBean.LoginSuccessUser) {
				c_status = new Cookie(WebUtility.cookie_status, user.getLogType().toString());
				c_status.setMaxAge(-1);
				res.addCookie(c_status);
				res.setContentType("text/html");  
			    PrintWriter out=res.getWriter();   
				out.println("<script>");  
			    out.println("alert('Você não possuí permissão para acessar esta área!');");  
			    out.println("document.location=('/GraoPara/protected/user/indexUser.jsp');");  
			    out.println("</script>");
			}
			else {
				res.setContentType("text/html");  
			    PrintWriter out=res.getWriter();   
				out.println("<script>");  
			    out.println("alert('Você não possuí permissão para acessar esta área!');");  
			    out.println("document.location=('/GraoPara/public/index.jsp');");  
			    out.println("</script>");
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