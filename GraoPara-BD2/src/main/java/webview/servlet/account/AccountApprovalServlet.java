package webview.servlet.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;
import webview.util.AlertsUtility;

import business.EJB.user.AdminBean;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

@WebServlet("/protected/admin/approveAccount")
public class AccountApprovalServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountApprovalServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminBean adminBean = new AdminBean();
		
		try {
			adminBean.alterarPermissoesUsuario(request.getParameter("email"), "user" + request.getParameter("nivel"));
			response.sendRedirect(request.getContextPath() + "/protected/admin/painel.jsp");
		} catch (IncorrectProfileInformationException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro de profile inválido, contate o suporte.");
			e.printStackTrace();
		} catch (UnreachableDataBaseException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro de banco de dados, contate o suporte.");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro de usuário inválido, contate o suporte.");
			e.printStackTrace();
		} catch (ProfileNotFoundException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro de profile não encontrado, contate o suporte.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (UpdateEntityException e) {
			e.printStackTrace();
		}
	}

}