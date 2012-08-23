package webview.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import business.EJB.docEJB.BuscaPalavraChaveEJB;
import business.EJB.userEJB.BuscaUserEJB;
import business.EJB.userEJB.Password;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

import persistence.dto.DTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.UserDTO;


public class PanelWorker {

	public static void listAllKeyWords(HttpServletRequest request, JspWriter out) throws IOException{
		BuscaPalavraChaveEJB busca = new BuscaPalavraChaveEJB();
		List<DTO> keys = null;	    
		try{ 
			keys = busca.buscaPalavrasChaves();

			for(DTO k : keys){
				PalavraChaveDTO key = (PalavraChaveDTO) k;

				out.write("<tr>");
				out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.getId() + "</label> </td>");
				out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.getPalavra() + " </label> </td>");
				out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.isAprovada() + "</label> </td>");
				out.write("<td><a href=\"#\"><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a><a href=\"#\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a></td>");
				out.write("</tr>");
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
		} catch (KeywordNotFoundException e) {
			out.println("<td colspan=\"3\">Nenhuma palavra-chave encontrada</td>");
		}
	}

	public static void listAllNewKeyWords(HttpServletRequest request, JspWriter out) throws IOException{
		BuscaPalavraChaveEJB busca = new BuscaPalavraChaveEJB();
		List<DTO> keys = null;	    
		try{
			keys = busca.buscaPalavrasChavesPendentes();
			for(DTO k : keys){
				PalavraChaveDTO key = (PalavraChaveDTO) k;

				out.write("<tr>");
				out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.getId() + "</label> </td>");
				out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.getPalavra() + " </label> </td>");
				out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.isAprovada() + "</label> </td>");
				out.write("<td><a href=\"#\"><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a><a href=\"#\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a></td>");
				out.write("</tr>");
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
		} catch (KeywordNotFoundException e) {
			out.println("<td colspan=\"3\">Nenhuma palavra-chave encontrada</td>");
		}
	}	
	
	
	public static void listAllUsers(HttpServletRequest request, JspWriter out) throws IOException{
		BuscaUserEJB busca = new BuscaUserEJB();
		List<DTO> users = null;	    
		try {
			users = busca.listUsers();
			
			for(DTO u : users){
				UserDTO user = (UserDTO) u;
				
				out.println("<tr>");
				out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getName() + "</label> </td>");
				out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getEmail() + " </label> </td>");
				out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getUserProfile().getProfile() + "</label> </td>");
				out.println("<td>"
						+ "<a href=\"/GraoPara/doChangesToAccount?" + Password.getHash("email") + "=" + user.getEmail() + 
						"&"+ Password.getHash("action") + "=" + Password.getHash("edit") + "&tab=3\" ><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
						+ "<a href=\"/GraoPara/doChangesToAccount?" + Password.getHash("email") + "=" + user.getEmail() + 
						"&"+ Password.getHash("action") + "=" + Password.getHash("delete") + "&tab=3\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
						+ "</td>");
				out.println("</tr>");
				out.println("</tr>");
			}
				
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"3\">Nenhum usuário encontrado</td>");
		}
	}
	
	public static void listAllNewUsers(HttpServletRequest request, JspWriter out) throws IOException{
		BuscaUserEJB busca = new BuscaUserEJB();
		List<DTO> users = null;	    
		try {
			users = busca.listUsers();
			
			for(DTO u : users){
				UserDTO user = (UserDTO) u;
				
				if(user.getUserProfile().getProfile().equals("default")){
					out.println("<tr>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getName() + "</label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getEmail() + " </label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getUserProfile().getProfile() + "</label> </td>");
					out.println("<td>"
							+ "<a href=\"/GraoPara/doChangesToAccount?" + Password.getHash("email") + "=" + user.getEmail() + 
							"&"+ Password.getHash("action") + "=" + Password.getHash("approve") + "&tab=2\" ><img src=\"/GraoPara/images/approve.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
							+ "<a href=\"/GraoPara/doChangesToAccount?" + Password.getHash("email") + "=" + user.getEmail() + 
							"&"+ Password.getHash("action") + "=" + Password.getHash("delete") + "&tab=2\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
							+ "</td>");
					out.println("</tr>");
				}
			}
				
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"3\">Nenhum usuário encontrado</td>");
		}
	}
	
	public static void removeUser(HttpServletRequest request, JspWriter out) throws IOException{
		  
		
	}
}
