package webview.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.JavascriptAlerts;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/doLogout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] c_list = request.getCookies();
		for(Cookie c : c_list){
			c.setMaxAge(0);
			response.addCookie(c);
		}
		
		JavascriptAlerts.alertAndRedirectPage(response, "Logout feito com sucesso!");
		
		response.sendRedirect("/GraoPara/public/index.jsp");
	}

}
