package webview.servlet.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.UserAccount;
import persistence.exceptions.UpdateEntityException;

import webview.util.JavascriptAlerts;
import webview.util.WebUtility;
import business.EJB.user.AdminBean;
import business.EJB.user.AuthBean;
import business.EJB.user.RegisterUserBean;
import business.EJB.user.SearchUserEJB;
import business.EJB.util.EJBUtility;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Servlet implementation class AccoutRemoveServlet
 */
@WebServlet("/doChangesToAccount")
public class AccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterUserBean cadastro = new RegisterUserBean();
		SearchUserEJB busca = new SearchUserEJB();
		AdminBean admin = new AdminBean();
		
		String action = request.getParameter("action");
		String permissaoNova;
		String senhaVelha;
		String senhaNova;
		UserAccount user = null;
		response.setContentType("text/html");  
		String email = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_email).getValue();
		String status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();


		if(status.equals(AuthBean.LoginSuccessUser)) {
		} else if(status.equals(AuthBean.LoginSuccessAdmin)) {
		}

		if(action.equals("editPermission")){
			permissaoNova = request.getParameter("permissao");
			email = request.getParameter("email");
			
			JavascriptAlerts.alertAndRedirectHistory(response, "Permissão trocado com sucesso.");
			
			try {
				admin.alterarPermissoesUsuario(email, permissaoNova);
			} catch (UnreachableDataBaseException e) {
				
				JavascriptAlerts.alertAndRedirectHistory(response, "Não foi possível conectar com o banco de dados.");
				e.printStackTrace();
				
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			} catch (IncorrectProfileInformationException e) {
				e.printStackTrace();
			} catch (ProfileNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (UpdateEntityException e) {
				e.printStackTrace();
			}
		}

		else if(action.equals("editPassword")){
			senhaVelha = request.getParameter("senhaAtual");
			senhaNova = request.getParameter("senhaNova");
			try {
				user = busca.findUser(email);
				
				if(user.getPassword().equals(EJBUtility.getHash(senhaVelha, "MD5"))){
					
					user.setPassword(EJBUtility.getHash(senhaNova, "MD5"));
					cadastro.atualizarUsuario(user);  
					
					JavascriptAlerts.alertAndRedirectHistory(response, "Senha trocada com sucesso.");
				}
				else{
					
					JavascriptAlerts.alertAndRedirectHistory(response, "Erro ao trocar a senha, senha informada diferente da cadastrada.");
				}
			} catch (UnreachableDataBaseException e) {
				
				JavascriptAlerts.alertAndRedirectHistory(response, "Não foi possível conectar com o banco de dados.");
				e.printStackTrace();
				
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (UpdateEntityException e) {
				e.printStackTrace();
			}	
		}
	}

}