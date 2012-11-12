package webview.servlet.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.UserAccount;
import business.DAO.login.UserDAO;
import business.EJB.user.AdminBean;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Servlet implementation class AccountRemovalServlet
 */
@WebServlet("/protected/admin/removeAccount")
public class AccountRemovalServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountRemovalServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO loginDAO = new UserDAO();
		
		UserAccount userToRemove = null;
		
		AdminBean adm = new AdminBean();
		
		String tab = request.getParameter("tab");
		String email = request.getParameter("email");

		try {
			userToRemove = loginDAO.findUserByEmail(email);
		} catch (UnreachableDataBaseException e1) {
			e1.printStackTrace();
		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			adm.deletarUsuario(email);

			if(userToRemove.getProfile().equals("default"))
				response.sendRedirect("/GraoPara/protected/admin/painel.jsp#tab"+tab); 
			else
				response.sendRedirect("/GraoPara/protected/admin/painel.jsp#tab"+tab);

		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}