package webview.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.JavascriptAlerts;
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
		// TODO Auto-generated constructor stub
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
			
			JavascriptAlerts.alertAndRedirectPage(response, "Senha inválida! Tente novamente.", "/GraoPara/protected/admin/cadUserAdmin.jsp");
			
		} else {
			
			AdminBean adminBean = new AdminBean();
			
			try {
				adminBean.adicionarUsuario(email, nome, senha, permissao);
				response.setContentType("text/html");
				
				JavascriptAlerts.alertAndRedirectPage(response, "Usuário adicionado!", "/GraoPara/protected/admin/cadUserAdmin.jsp");

			} catch (UnreachableDataBaseException e) {
				
				JavascriptAlerts.alertAndRedirectPage(response, "Erro no banco de dados! Contate o suporte e tente novamente mais tarde.", "/GraoPara/protected/admin/cadUserAdmin.jsp");
				e.printStackTrace();
			} catch (IncorrectLoginInformationException e) {
				
				JavascriptAlerts.alertAndRedirectPage(response, "Email inválido!", "/GraoPara/protected/admin/cadUserAdmin.jsp");
			} catch (DuplicateUserException e) {
				
				JavascriptAlerts.alertAndRedirectPage(response, "Email já em uso!", "/GraoPara/protected/admin/cadUserAdmin.jsp");
			}
		}
	}
	
}
