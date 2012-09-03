package webview.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;
import persistence.utility.DataAccessLayerException;

import business.DAO.login.LoginDAO;
import business.EJB.userEJB.AdminBean;
import business.exceptions.login.IncorrectProfileInformationException;
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userToRemove = null;
		AdminBean adm = new AdminBean();
		String email = request.getParameter("email");

		try {
			userToRemove = loginDAO.findUserByEmail(email);
		} catch (UnreachableDataBaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			adm.deletarUsuario(email);

			if(userToRemove.getUserProfile().getProfile().equals("default"))
				response.sendRedirect("/GraoPara/protected/admin/painelAdmin.jsp#tab1"); 
			else
				response.sendRedirect("/GraoPara/protected/admin/painelAdmin.jsp#tab2");
			
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}
}
