package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.WebUtility;

import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.CadastroBean;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Servlet implementation class AccountRecoveryServlet
 */
@WebServlet("/doPasswordRecovery")
public class AccountRecoveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRecoveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroBean recovery = new CadastroBean();
		String email = request.getParameter("email");
		String newPassword;
	    PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String session = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_session).getValue();
		String mail = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_email).getValue();
		String username = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_nome).getValue();
		String status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();
		if(AuthBean.allowOperation(session, mail, username, status)){
			try {
				newPassword = recovery.recuperarSenha(email);
				out.println("<script>");  
			    out.println("alert('Anote sua nova senha: " + newPassword + ". Você pode trocar a sua senha após o login.');");  
			    out.println("document.location=('/GraoPara/protected/user/');");  
			    out.println("</script>");
			} catch (UnreachableDataBaseException e) {
				out.println("<script>");  
			    out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde." + e.getStackTrace() + "');");  
			    out.println("document.location=('/GraoPara/protected/user/');");  
			    out.println("</script>");
				e.printStackTrace();
			} catch (UserNotFoundException e) { 
			    out.println("<script>");  
			    out.println("alert('Email não encontrado. Verifique o email e tente novamente. ');");  
			    out.println("document.location=('/GraoPara/public/index.jsp');");  
			    out.println("</script>");
			}
		}
		else{
		    out.println("<script>");  
		    out.println("alert('Você não tem permissão suficiente. ');");  
		    out.println("document.location=('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
		}
		
	}
}
