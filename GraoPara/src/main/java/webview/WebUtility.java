package webview;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import persistence.dto.DocumentoDTO;
import persistence.dto.ProfileDTO;

import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.UserBean;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public final class WebUtility {
	
	public static String cookie_email = "email_graopara";
	public static String cookie_session = "sessao_graopara";
	public static String cookie_nome = "nome_graopara";
	public static String cookie_status = "status_graopara";
	
	public static ProfileDTO admin_profile = new ProfileDTO("admin", true, true, true);
	public static ProfileDTO user_profile = new ProfileDTO("user", true, true, false);
	public static ProfileDTO default_profile = new ProfileDTO("default", false, true, false);
	
	public static int cookie_expire = -1; //1 sessão dias
	
	public static UserBean cookieLogin(Cookie[] cookie_list) {
		if(cookie_list == null) return null;
		
		String email = null;
		String password = null;
		for(int i = 0; i < cookie_list.length; i++) {
			Cookie cookie = cookie_list[i];
			String cName = cookie.getName();
			if(cName.equals(WebUtility.cookie_email))
				email = cookie.getValue();
			if(cName.equals(WebUtility.cookie_session))
				password = cookie.getValue();
		}
		if(email != null && password != null) {
			try {
				UserBean result = AuthBean.validarLogin(email, password, AuthBean.HashedPwd);
				return result;
			} catch (UnreachableDataBaseException e) {
				e.printStackTrace();
				return null;
			} catch (UserNotFoundException e) {
				return null;
			}
		}
		return null;
	}
	
	public static Cookie selectCookie(Cookie[] c_list, String c_name) {
		if(c_list == null) return null;
		
		for(int i = 0; i < c_list.length; i++) {
			Cookie cookie = c_list[i];
			String cName = cookie.getName();
			if(cName.equals(c_name)) return cookie;
		}
		return null;
	}
	
	public static String strDiff(String str1, String str2) {
		int idx = str1.lastIndexOf(str2);
	    if (idx > -1) {
	      return str1.substring(str2.length());
	    }
	    else return str1;
	}
	
	public static String docToString(DocumentoDTO doc) {
		return
				doc.getOrigemDocumento().getTitulo() + "\n"
				+ doc.getAutor() + " "
				+ doc.getDestinatario() + " "
				+ doc.getLocal() + " "
				+ doc.getResumo() + " "
				+ doc.getDataDocumento().toString()
				+ " --- "
				+ doc.getUploader().getEmail() + " "
				+ doc.getDataInclusao().toString()
				+ " --- "
				+ doc.getIdNumDocumento().getTipoId() + " "
				+ doc.getIdNumDocumento().getCodId() + " "
				+ doc.getOrigemDocumento().getTipoOrigem() + " "
				+ doc.getOrigemDocumento().getCodOrigem() + " ";
	}
	
	public static void printName(HttpServletRequest request, JspWriter out) throws IOException {
		Cookie name = selectCookie(request.getCookies(), WebUtility.cookie_nome);
		if(name != null) out.write("<label>" + name.getValue() + "!</label>");
	}
	
	public static String printLabel(HttpServletRequest request, String parameter) throws IOException {
		String label = request.getParameter(parameter);
		if(label == null) return "";
		else return label;
	}
	
	public static String printSelectOrigem(HttpServletRequest request) throws IOException {
		String output = null;
		if(request.getParameter("identificacao").equals("codice"))
		{
			output = 
					"<option selected value=\"codice\">Número de Códice</option> " +
					"<option value=\"caixa\">Número da Caixa</option>";
		}
		else if(request.getParameter("identificacao").equals("caixa"))
		{
			output = 
					"<option value=\"codice\">Número de Códice</option> " +
					"<option selected value=\"caixa\">Número da Caixa</option>";
		}
		return output;
	}
	
	public static String printSelectId(HttpServletRequest request) throws IOException {
		String output = null;
		if(request.getParameter("tipo_num").equals("APEP"))
		{
			output = 
					"<option selected value=\"APEP\">APEP</option> " +
					"<option value=\"SEQ\">Sequencial</option>";
		}
		else if(request.getParameter("identificacao").equals("SEQ"))
		{
			output = 
					"<option value=\"APEP\">APEP</option> " +
					"<option selected value=\"SEQ\">Sequencial</option>";
		}
		return output;
	}

}
