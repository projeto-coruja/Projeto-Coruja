package webview.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import business.EJB.user.AuthBean;

@WebFilter({"/protected/userAdv/*", "/protected/userAdv/"})
public class UserAdvFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserAdvFilter() {
        //  Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//  Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		FilterUtility.trueFilter(AuthBean.LoginSuccessUserLevel2, request, response, chain);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//  Auto-generated method stub
	}

}
