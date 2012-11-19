package webview.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.AlertsUtility;
import webview.util.WebUtility;
import business.EJB.user.AdminBean;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class AdminCadServlet
 */
@WebServlet("/protected/admin/doAdminRegister")
public class AdminRegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = WebUtility.removeAccents(request.getParameter("nome"));
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String permissao = request.getParameter("permissao");

		if (!senha.equals(request.getParameter("confsenha"))) {
			
			AlertsUtility.alertAndRedirectPage(response, "Senha inválida! Tente novamente.", "/GraoPara/protected/admin/cadUser.jsp");
			
		} else {
			
			AdminBean adminBean = new AdminBean();
			
			try {
				adminBean.adicionarUsuario(email, nome, senha, permissao);
				response.setContentType("text/html; charset=UTF-8");
				
				AlertsUtility.alertAndRedirectPage(response, "Usuário adicionado!", "/GraoPara/protected/admin/cadUser.jsp");

			} catch (UnreachableDataBaseException e) {
				
				AlertsUtility.alertAndRedirectPage(response, "Erro no banco de dados! Contate o suporte e tente novamente mais tarde.", "/GraoPara/protected/admin/cadUser.jsp");
				e.printStackTrace();
			} catch (IncorrectLoginInformationException e) {
				
				AlertsUtility.alertAndRedirectPage(response, "Email inválido!", "/GraoPara/protected/admin/cadUser.jsp");
			} catch (DuplicateUserException e) {
				
				AlertsUtility.alertAndRedirectPage(response, "Email já em uso!", "/GraoPara/protected/admin/cadUser.jsp");
			}
		}
	}
	
}
