package webview.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.JavascriptAlerts;
import webview.util.WebUtility;
import business.EJB.user.RegisterUserBean;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/doRegister")
public class UserRegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = WebUtility.removeAccents(request.getParameter("nome"));
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		if(!senha.equals(request.getParameter("confsenha"))){
			
			JavascriptAlerts.alertAndRedirectHistory(response, "Senha inválida! Tente novamente.");
			
		}
		else
		{
			RegisterUserBean register = new RegisterUserBean();
			try {
				register.addUser(email, senha, nome);
				
				JavascriptAlerts.alertAndRedirectPage(response, "Usuário adicionado! Aguarde a aprovação dos seus direitos de edição.", "/GraoPara/public/index.jsp");
			} catch (IncorrectLoginInformationException e) {
				
				JavascriptAlerts.alertAndRedirectPage(response, "Email inválido! Por favor tente novamente.", "/GraoPara/public/CadUsuario.jsp");
				
			} catch (DuplicateUserException e) {
				
				JavascriptAlerts.alertAndRedirectPage(response, "Email já em uso! Por favor tente novamente.", "/GraoPara/public/CadUsuario.jsp");
			}
		}
	}

}
