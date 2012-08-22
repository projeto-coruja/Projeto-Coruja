package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.userEJB.BuscaUserEJB;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

import persistence.dto.DTO;
import persistence.dto.UserDTO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class PainelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PainelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public static void listAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BuscaUserEJB busca = new BuscaUserEJB();
		List<DTO> users = null;
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();  
	    
		try {
			users = busca.listUsers();
			
			for(DTO u : users){
				out.println("<tr>");
				
				UserDTO user = (UserDTO) u;
				out.println("<td width=\"120\" height=\"20\">" + user.getName() + "</td>");
				out.println("<td width=\"120\" height=\"20\">" + user.getEmail() + "</td>");
				out.println("<td width=\"120\" height=\"20\">" + user.getUserProfile().getProfile() + "</td>");
				
				out.println("</tr>");
			}
				
		} catch (UnreachableDataBaseException e) {
		    out.println("<script>");  
		    out.println("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
		    out.println("document.location=('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"3\">Nenhum usuário encontrado</td>");
		}
		
	}
}
