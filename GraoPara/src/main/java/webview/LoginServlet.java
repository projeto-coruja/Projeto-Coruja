package webview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.EJB.AuthBean;
import business.EJB.Password;
import business.exceptions.UnreachableDataBaseException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
			if(AuthBean.validarLogin(user, senha, AuthBean.NonHashedPwd))
			{
				Cookie c_email = new Cookie("email_graopara", user);
				Cookie c_pass = new Cookie("userpwd_graopara", Password.getHash(senha));
				c_email.setMaxAge(WebUtility.cookie_expire);
				c_pass.setMaxAge(WebUtility.cookie_expire);
				response.addCookie(c_email);
				response.addCookie(c_pass);
				HttpSession session = request.getSession();
				session.setAttribute("isLogged", "true");
				//Qualquer coisa que mude a página, ou redirecionar para uma nova página só para usuários logados, provisório
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
			    out.println("<script>");  
			    out.println("alert('Login realizado com sucesso!');");  
			    out.println("document.location=('/GraoPara/');");  
			    out.println("</script>");
			}
			else
			{
				//Exibir alerta e jogar de volta para o index, provisório
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
			    out.println("<script>");  
			    out.println("alert('Login incorreto! Verifique seu email e senha, e tente de novo. ');");  
			    out.println("document.location=('/GraoPara/');");  
			    out.println("</script>");
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		}
	}

}
