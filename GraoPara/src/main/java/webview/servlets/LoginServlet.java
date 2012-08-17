package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.WebUtility;

import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.Password;
import business.EJB.userEJB.UserBean;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("login");
		String senha = request.getParameter("senha");
		try {
			UserBean login_result = AuthBean.validarLogin(user, senha, AuthBean.NonHashedPwd);
			if(login_result != null && (login_result.getLogType() == AuthBean.LoginSuccessAdmin || login_result.getLogType() == AuthBean.LoginSuccessUser))
			{
				Cookie c_email = new Cookie(WebUtility.cookie_email, user);
				Cookie c_pass = new Cookie(WebUtility.cookie_password, Password.getHash(senha));
				Cookie c_status = new Cookie(WebUtility.cookie_status, login_result.getLogType().toString());
				Cookie c_nome = new Cookie(WebUtility.cookie_nome, login_result.getUsername());
				c_email.setMaxAge(WebUtility.cookie_expire);
				c_pass.setMaxAge(WebUtility.cookie_expire);
				c_status.setMaxAge(-1);
				c_nome.setMaxAge(WebUtility.cookie_expire);
				response.addCookie(c_email);
				response.addCookie(c_pass);
				response.addCookie(c_status);
				response.addCookie(c_nome);
			    
			    if(login_result.getLogType() == AuthBean.LoginSuccessUser)	// retorna para a página de USER
			    	response.sendRedirect("/GraoPara/protected/user/indexUser.jsp");
			    else if(login_result.getLogType() == AuthBean.LoginSuccessAdmin)	// retorna para a página de ADMIN
			    	response.sendRedirect("/GraoPara/protected/admin/indexAdmin.jsp");
			}
			else
			{
				//Exibir alerta e jogar de volta para o index, provisório
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
			    out.println("<script>");  
			    out.println("alert('Login incorreto! Verifique seu email e senha, e tente de novo. ');");  
			    out.println("document.location=('/GraoPara/public/index.jsp');");  
			    out.println("</script>");
			}
			
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		}
	}

}
