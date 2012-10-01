package webview.servlet.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.UserAccount;
import persistence.exceptions.UpdateEntityException;
import webview.servlet.util.JavascriptAlerts;
import business.EJB.user.RegisterUserBean;
import business.EJB.user.SearchUserEJB;
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
		SearchUserEJB busca = new SearchUserEJB();
		RegisterUserBean cadastro = new RegisterUserBean();
		String newPassword = null;
		String email = request.getParameter("email"); 

		try {
			UserAccount user = busca.findUser(email);
			newPassword = EJBUtility.genRandomString(6);
			user.setPassword(EJBUtility.getHash(newPassword, "MD5"));
			cadastro.atualizarUsuario(user);
		    
			JavascriptAlerts.alertAndRedirectHistory(response, "Nova senha gerado para "+ email +": "+ newPassword, "/GraoPara/protected/admin/gerarSenha.jsp");
			
		} catch (UnreachableDataBaseException e) {
			
			JavascriptAlerts.alertAndRedirectHistory(response, "Problema ao se conectar ao banco de dados.", "/GraoPara/protected/admin/gerarSenha.jsp");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			
			JavascriptAlerts.alertAndRedirectHistory(response, "Usuário não encontrado.", "/GraoPara/protected/admin/gerarSenha.jsp");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UpdateEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}