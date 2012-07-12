package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

public class ConnectionFilter implements Filter {
	private SessionFactory session;

	@Override
	public void destroy() {	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response ,FilterChain chain) throws IOException, ServletException {
		try{
			this.session.getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			this.session.getCurrentSession().getTransaction().commit();
			this.session.getCurrentSession().close();
		}
		catch (Throwable e){
			try{
				if(this.session.getCurrentSession().getTransaction().isActive())
					this.session.getCurrentSession().getTransaction().rollback();
				
			}catch (Throwable e2){
				e2.printStackTrace();
			}
		}
		
		throw new ServletException();
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		this.session = (SessionFactory) HibernateUtil.getSession().getCurrentSession(); 

	}

}
