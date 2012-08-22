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
			
			out.println("<tr>");
			out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">Nome</label></td>");
			out.println("<td> <label for=\"identificacao\"	class=\"labelExibe\">Email</label></td>");
			out.println("<td> <label for=\"identificacao\"	class=\"labelExibe\">Permissão</label></td>");
			out.println("<td> <label for=\"identificacao\"	class=\"labelExibe\">Ação</label></td>");
			out.println("</tr>");
			
			for(DTO u : users){
				out.println("<tr>");
				
				UserDTO user = (UserDTO) u;
				out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getName() + "</label> </td>");
				out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getEmail() + " </label> </td>");
				out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getUserProfile().getProfile() + "</label> </td>");
				out.println("<td><a href=\"#\"><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a><a href=\"#\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a></td>");
				
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
	
	public static void listAllNewUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BuscaUserEJB busca = new BuscaUserEJB();
		List<DTO> users = null;
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();  
	    
		try {
			users = busca.listUsers();
			
			out.println("<tr>");
			out.println("<td class=\"coluna\"> <label for=\"identificacao\" class=\"labelExibe\">Nome</label></td>");
			out.println("<td class=\"coluna\"> <label for=\"identificacao\"	class=\"labelExibe\">Email</label></td>");
			out.println("<td class=\"coluna\"> <label for=\"identificacao\"	class=\"labelExibe\">Permissão</label></td>");
			out.println("<td class=\"coluna\"> <label for=\"identificacao\"	class=\"labelExibe\">Ação</label></td>");
			out.println("</tr>");
			
			for(DTO u : users){
				UserDTO user = (UserDTO) u;
				if(user.getUserProfile().getProfile() == "default"){
					out.println("<tr>");
					out.println("<td >" + user.getName() + "</td>");
					out.println("<td >" + user.getEmail() + "</td>");
					out.println("<td >" + user.getUserProfile().getProfile() + "</td>");
					out.println("<td> COLOCAR AÇÃO </td>");	
					out.println("</tr>");
				}
			}
				
		} catch (UnreachableDataBaseException e) {
		    out.println("<script>");  
		    out.println("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');");  
		    out.println("document.location=('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"3\">Nenhum usuário encontrado</td>");
		}
		
	}

	
}
