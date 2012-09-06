package webview.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import business.DAO.documents.OrigemDAO;
import business.EJB.docEJB.BuscaPalavraChaveEJB;
import business.EJB.userEJB.AdminBean;
import business.EJB.userEJB.BuscaUserEJB;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.OriginNotFoundException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

import persistence.dto.DTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.ProfileDTO;
import persistence.dto.UserDTO;
import webview.WebUtility;


public class PanelWorker {

	public static void listAllKeyWords(HttpServletRequest request, JspWriter out)  throws IOException{
		BuscaPalavraChaveEJB busca = new BuscaPalavraChaveEJB();
		List<DTO> keys = null;	    
		String in = (String) request.getAttribute("in");
		String td = null;
		if(in.equals("cadastrarPalavrasChave.jsp"))		td =  "class=\"tdList\"";
		else	td = "";
		try{ 
			keys = busca.buscaPalavrasChaves();

			for(DTO k : keys){
				PalavraChaveDTO key = (PalavraChaveDTO) k;

				out.write("<tr>");
				out.write("<td "+td+"> <label for=\"identificacao\" class=\"labelExibe\">" + key.getId() + "</label> </td>");
				out.write("<td "+td+"> <label for=\"identificacao\" class=\"labelExibe\">" + key.getPalavra() + " </label> </td>");
				/*out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + (key.isAprovada()==true ? "Aprovada" : "Pendente") + "</label> </td>");*/
				out.println("<td "+td+">"
						+ "<a href=\"/GraoPara/protected/admin/editarPalavraChave.jsp?"
							+ "palavra="+ key.getPalavra() +"\" >"
							+ "<img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
						+ "<a href=\"/GraoPara/protected/admin/doChangesToKeyWord?" 
							+ "palavra=" + key.getPalavra()  
							+ "&action=delete"
							+ "&from=" + in
							+ "\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
						+ "</td>");
				out.write("</tr>");
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
		} catch (KeywordNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhuma palavra-chave encontrada</label></td>");
		}
	}
	
	public static void listAllNewKeyWords(HttpServletRequest request, JspWriter out) throws IOException{
		BuscaPalavraChaveEJB busca = new BuscaPalavraChaveEJB();
		List<DTO> keys = null;	    
		try{
			keys = busca.buscaPalavrasChavesPendentes();
			for(DTO k : keys){
				PalavraChaveDTO key = (PalavraChaveDTO) k;

				if(!key.isAprovada()){
					out.write("<tr>");
					out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.getId() + "</label> </td>");
					out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + key.getPalavra() + " </label> </td>");
					out.write("<td> <label for=\"identificacao\" class=\"labelExibe\">" + (key.isAprovada()==true ? "Aprovada" : "Pendente") + "</label> </td>");
					out.println("<td>"
							+ "<a href=\"/GraoPara/doChangesToKeyWord?" 
								+ "palavra=" + key.getPalavra() 
								+ "&action=approve"
								+ "&tab=1\" >"
								+ "<img src=\"/GraoPara/images/approve.png\" title=\"Aprovar\" alt=\"Aprovar\" /></a>" 
							+ "<a href=\"/GraoPara/doChangesToKeyWord?" 
								+ "palavra=" + key.getPalavra() 
								+ "&action=delete"
								+ "&tab=1\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
							+ "</td>");
					out.write("</tr>");
				}
				
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
		} catch (KeywordNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhuma palavra-chave encontrada.</label></td>");
		}
	}	
	
	public static void listAllOrigins(HttpServletRequest request, JspWriter out) throws IOException{
		OrigemDAO od = new OrigemDAO();
		List<DTO> origens = null;	    
		try{
			origens = od.findAllOrigins();
			for(DTO k : origens){
				OrigemDTO ori = (OrigemDTO) k;				
				out.write("<tr>");
				out.write("<td class=\"tdList\"> <label for=\"identificacao\" class=\"labelExibe\">" + ori.getTipoOrigem() + " </label> </td>");
				out.write("<td class=\"tdList\"> <label for=\"codigo\" class=\"labelExibe\">" + ori.getCodOrigem() + " </label> </td>");
				out.write("<td class=\"tdList\"> <label for=\"titulo\" class=\"labelExibe\">" + ori.getTitulo() + " </label> </td>");
				out.println("<td class=\"tdList\">"
						+ "<a href=\"/GraoPara/protected/admin/editarTituloOrigem.jsp?" 
						+ "identificacao=" + ori.getTipoOrigem()
						+ "&codigo=" + ori.getCodOrigem()
						+ "\"><img src=\"/GraoPara/images/edit.png\" title=\"Editar título\" alt=\"Editar título\" /></a>"
						+ "</td>");
				out.write("</tr>");
				
				
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
		} catch (OriginNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhuma palavra-chave encontrada.</label></td>");
		}
	}
	
	public static void listAllUsers(HttpServletRequest request, JspWriter out) throws IOException{
		String c_email = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_email).getValue();
		BuscaUserEJB busca = new BuscaUserEJB();
		List<DTO> users = null;	    
		try {
			users = busca.listUsers();
			
			for(DTO u : users){
				UserDTO user = (UserDTO) u;
				
				if(!user.getEmail().equals(c_email)){
					out.println("<tr>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getName() + "</label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getEmail() + " </label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getUserProfile().getProfile() + "</label> </td>");
					out.println("<td>"
							+ "<a href=\"/GraoPara/protected/admin/editarUsuario.jsp?"
							+ "paramName=" + user.getName()
							+"&paramEmail="+user.getEmail()+"\" ><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
							+ "<a href=\"/GraoPara/protected/admin/removeAccount?" 
							+ "email=" + user.getEmail()
							+ "&tab=3\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
							+ "</td>");
					out.println("</tr>");
					out.println("</tr>");
				}
			}
				
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhum usuário encontrado.</label></td>");
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
						+ "<a href=\"/GraoPara/protected/admin/approveAccount?" 
							+ "email=" + user.getEmail()
							+ "&action=delete" + "&tab=3\"><img src=\"/GraoPara/images/approve.png\" title=\"Aprovar\" alt=\"Aprovar\" /></a>"
						+ "<a href=\"/GraoPara/protected/admin/editarUsuario.jsp?"
							+ "paramName=" + user.getName()
							+"&paramEmail="+user.getEmail()+"\" ><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
						+ "<a href=\"/GraoPara/protected/admin/removeAccount?" 
							+ "email=" + user.getEmail()
							+ "&tab=3\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
							+ "</td>");
					out.println("</tr>");
				}
			}
				
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhum usuário encontrado.</label></td>");
		}
	}
	

	public static void listAllAvailablePofile(HttpServletRequest request, JspWriter out) throws IOException{
		AdminBean adm = new AdminBean();
		List<DTO> list;
		try {
			list = adm.getAllAvailableProfiles();
			for(DTO dto : list){
				ProfileDTO profile = (ProfileDTO) dto;
				out.println("<option value=\""+ profile.getProfile() +"\">"+ profile.getProfile() + "</option>");
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
