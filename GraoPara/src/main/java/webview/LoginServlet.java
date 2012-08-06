package webview;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.AutenticacaoFacade;
import business.EJB.Password;
import business.exceptions.UnreachableDataBaseException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("login");
		String senha = request.getParameter("senha");
		AutenticacaoFacade af = new AutenticacaoFacade();
		try {
			if(af.validarLogin(user, senha))
			{
				Cookie c_user = new Cookie("user_graopara", user);
				//Cookie c_pass = new Cookie("userpwd_graopara", Password.getHash(senha));
				response.addCookie(c_user);
				//response.addCookie(c_pass);				
			} 
			else
			{
				response.sendRedirect("NOPE.jsp");
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
			response.sendRedirect("VIXE.jsp");
		}
	}

}
