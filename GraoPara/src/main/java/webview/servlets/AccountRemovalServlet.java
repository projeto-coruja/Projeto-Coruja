package webview.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.userEJB.AdminBean;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
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
		AdminBean adm = new AdminBean();
		String email = request.getParameter("email");
		String action = request.getParameter("action");
		String previous = request.getParameter("tab");
		
		try {
			if(action.equals("approve")) adm.alterarPermissoesUsuario(email, "user");
			else if(action.equals("delete"))	adm.deletarUsuario(email);
		} catch (IncorrectProfileInformationException e) {
			e.printStackTrace();
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("/GraoPara/protected/admin/painelAdmin.jsp#tab"+previous);
	}

}
