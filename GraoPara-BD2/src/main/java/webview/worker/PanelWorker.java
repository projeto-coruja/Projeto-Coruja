package webview.worker;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import business.EJB.documents.CodiceCaixaEJB;
import business.EJB.documents.KeyWordEJB;

import business.EJB.user.AdminBean;
import business.EJB.user.SearchUserBean;

import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;
import persistence.dto.PalavraChave;
import persistence.dto.Profile;
import persistence.dto.UserAccount;

import webview.util.WebUtility;


public class PanelWorker {

	public static void listAllKeyWords(HttpServletRequest request, JspWriter out)  throws IOException{
		KeyWordEJB busca = new KeyWordEJB();
		List<DTO> keys = null;	    
		String in = (String) request.getAttribute("in");
		String td = null;		
		if(in.equals("cadastrarPalavrasChave.jsp"))
			td =  "class=\"tdList\"";
		else
			td = "";		
		try{ 
			keys = busca.buscaPalavrasChaves();
			for(DTO k : keys){
				PalavraChave key = (PalavraChave) k;
				out.write("<tr>");
				out.write("<td "+td+"> <label for=\"identificacao\" class=\"labelExibe\">" + key.getId() + "</label> </td>");
				out.write("<td "+td+"> <label for=\"identificacao\" class=\"labelExibe\">" + key.getPalavra().replace("_", " ") + " </label> </td>");
				out.println("<td "+td+">"
						+ "<a href=\"/GraoPara/protected/admin/editarPalavraChave.jsp?"
							+ "palavraAntiga="+ key.getPalavra()
							+ "&tema="+ key.getTema().getTema() + "\" >"
							+ "<img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
						+ "<a href=\"/GraoPara/protected/admin/doChangesToKeyWord?" 
							+ "palavraAntiga=" + key.getPalavra()
							+ "&tema="+ key.getTema().getTema()
							+ "&action=delete"
							+ "&from=" + in
							+ "\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
						+ "</td>");
				out.write("</tr>");
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');");
			out.write("</script>");
		} catch (KeywordNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhuma palavra-chave encontrada.</label></td>");
		}
	}	
	
	public static void listAllKeyWordsForUser(HttpServletRequest request, JspWriter out)  throws IOException{
		KeyWordEJB busca = new KeyWordEJB();
		List<DTO> keys = null;	    
		String in = (String) request.getAttribute("in");
		String td = null;		
		if(in.equals("cadastrarPalavrasChave.jsp"))
			td =  "class=\"tdList\"";
		else
			td = "";		
		try{ 
			keys = busca.buscaPalavrasChaves();
			for(DTO k : keys){
				PalavraChave key = (PalavraChave) k;
				out.write("<tr>");
				out.write("<td "+td+"> <label for=\"identificacao\" class=\"labelExibe\">" + key.getId() + "</label> </td>");
				out.write("<td "+td+"> <label for=\"identificacao\" class=\"labelExibe\">" + key.getPalavra().replace("_", " ") + " </label> </td>");
				out.write("</tr>");
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');");
			out.write("</script>");
		} catch (KeywordNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhuma palavra-chave encontrada.</label></td>");
		}
	}
	
	public static void listAllCodex(HttpServletRequest request, JspWriter out) throws IOException{
		CodiceCaixaEJB od = new CodiceCaixaEJB();
		List<DTO> origens = null;	    
		try{
			origens = od.getAllEntries();			
			for(DTO k : origens){
				CodiceCaixa ori = (CodiceCaixa) k;				
				out.print("<tr>");
				out.print("<td class=\"tdList\"> <label for=\"codigo\" class=\"labelExibe\">" + ori.getCod() + " </label> </td>");
				out.print("<td class=\"tdList\"> <label for=\"titulo\" class=\"labelExibe\">" + ori.getTitulo() + " </label> </td>");
				out.print("<td class=\"tdList\"> <label for=\"anoIni\" class=\"labelExibe\">" + ori.getAnoInicio() + " </label> </td>");
				out.print("<td class=\"tdList\"> <label for=\"anoFim\" class=\"labelExibe\">" + ori.getAnoFim() + " </label> </td>");
				out.println("<td class=\"tdList\">"
						+ "<a href=\"/GraoPara/protected/admin/editarTituloOrigem.jsp?" 
						+ "&codigo=" + ori.getCod()
						+ "&anoIni=" + ori.getAnoInicio()
						+ "&anoFim=" + ori.getAnoFim()
						+ "\"><img src=\"/GraoPara/images/edit.png\" title=\"Editar códice/caixa\" alt=\"Editar códice/caixa\" /></a>"
						+ "</td>");
				out.write("</tr>");				
			}
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');"); 
			out.write("</script>");
		} catch (CodiceCaixaNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhum cadastro de códice/caixa encontrado.</label></td>");
		}
	}
	
	public static void listAllUsers(HttpServletRequest request, JspWriter out) throws IOException{
		Cookie d_email = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_email);
		String c_email;		
		if(d_email == null)
			c_email = null;
		else
			c_email = d_email.getValue();		
		SearchUserBean busca = new SearchUserBean();
		List<DTO> users = null;	  		
		try {
			users = busca.listUsers();				
			for(DTO u : users){
				UserAccount user = (UserAccount) u;				
				if(!user.getEmail().equals(c_email)){
					out.println("<tr>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getName() + "</label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getEmail() + " </label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getProfile().getProfile() + "</label> </td>");
					out.println("<td>"
							+ "<a href=\"/GraoPara/protected/admin/editarUsuario.jsp?"
							+ "paramName=" + user.getName()
							+"&paramEmail="+user.getEmail()+"\" ><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
							+ "<a href=\"/GraoPara/protected/admin/removeAccount?" 
							+ "email=" + user.getEmail()
							+ "&tab=2\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
							+ "</td>");
					out.println("</tr>");
					out.println("</tr>");
				}
			}				
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');"); 
			out.write("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhum usuário encontrado.</label></td>");
		}
	}
	
	public static void listAllNewUsers(HttpServletRequest request, JspWriter out) throws IOException{
		SearchUserBean busca = new SearchUserBean();
		List<DTO> users = null;		
		try {
			users = busca.listUsers();			
			for(DTO u : users){
				UserAccount user = (UserAccount) u;				
				if(user.getProfile().getProfile().equals("default")){
					out.println("<tr>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getName() + "</label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getEmail() + " </label> </td>");
					out.println("<td> <label for=\"identificacao\" class=\"labelExibe\">" + user.getProfile().getProfile() + "</label> </td>");
					out.println("<td>"
						+ "<a href=\"/GraoPara/protected/admin/approveAccount?" 
							+ "email=" + user.getEmail()
							+ " \"><img src=\"/GraoPara/images/approve.png\" title=\"Aprovar\" alt=\"Aprovar\" /></a>"
						+ "<a href=\"/GraoPara/protected/admin/editarUsuario.jsp?"
							+ "paramName=" + user.getName()
							+"&paramEmail="+user.getEmail()+"\" ><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\" /></a>" 
						+ "<a href=\"/GraoPara/protected/admin/removeAccount?" 
							+ "email=" + user.getEmail()
							+ "&tab=1\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\" /></a>"
							+ "</td>");
					out.println("</tr>");
				}
			}				
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde.');"); 
			out.write("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<td colspan=\"4\"><label class=\"labelExibe\">Nenhum usuário novo encontrado.</label></td>");
		}
	}
	
	public static void listAllAvailableProfile(HttpServletRequest request, JspWriter out) throws IOException{
		AdminBean adm = new AdminBean();
		List<DTO> list;		
		try {
			list = adm.getAllAvailableProfiles();			
			for(DTO dto : list){
				Profile profile = (Profile) dto;
				out.println("<option value=\""+ profile.getProfile() +"\">"+ profile.getProfile() + "</option>");
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
