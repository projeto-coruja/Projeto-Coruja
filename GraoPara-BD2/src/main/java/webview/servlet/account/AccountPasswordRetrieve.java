package webview.servlet.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;
import webview.util.AlertsUtility;

import business.EJB.user.RegisterUserBean;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;


@WebServlet("/passwordRecovery")
public class AccountPasswordRetrieve extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2804517812232329432L;

	public AccountPasswordRetrieve() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		RegisterUserBean bean = new RegisterUserBean();
		try {
			bean.recuperarSenha(email);
			AlertsUtility.alertAndRedirectHistory(response, "Senha resetado com sucesso, cheque o seu email.");
		} catch (UserNotFoundException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Usuário não encontrado!");
		} catch (IllegalArgumentException e) {
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (UpdateEntityException e) {
			e.printStackTrace();
		}
	}

}
