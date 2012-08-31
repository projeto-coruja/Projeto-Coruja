package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.UserDTO;
import business.EJB.userEJB.BuscaUserEJB;
import business.EJB.userEJB.CadastroBean;
import business.EJB.util.EJBUtility;
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
		BuscaUserEJB busca = new BuscaUserEJB();
		CadastroBean cadastro = new CadastroBean();
		String newPassword = null;
		String email = request.getParameter("email");
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter(); 
		
		try {
			UserDTO user = busca.findUser(email);
			newPassword = EJBUtility.genNewRandomPassword(6);
			user.setPassword(EJBUtility.getHash(newPassword, "MD5"));
			cadastro.atualizarUsuario(user);
		    out.println("<script>");  
		    out.println("alert('Nova senha gerado para "+ email +": "+ newPassword +" ');");  
		    out.println("document.location=('/GraoPara/protected/admin/gerarSenha.jsp');");  
		    out.println("</script>");
		} catch (UnreachableDataBaseException e) {
		    out.println("<script>");  
		    out.println("alert('Problema ao se conectar ao banco de dados. ');");  
		    out.println("document.location=('/GraoPara/protected/admin/gerarSenha.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
		    out.println("<script>");  
		    out.println("alert('Usuário não encontrado. ');");  
		    out.println("document.location=('/GraoPara/protected/admin/gerarSenha.jsp');");  
		    out.println("</script>");
		}
	}
}
