package webview;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.ProfileDTO;
import persistence.dto.TipoDocumentoDTO;

import business.DAO.documents.DocumentTypeDAO;
import business.DAO.documents.KeyWordDAO;
import business.DAO.documents.OrigemDAO;
import business.EJB.docEJB.BuscaPalavraChaveEJB;
import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.UserBean;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.OriginNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public final class WebUtility {
	
	public static final String cookie_email = "email_graopara";
	public static final String cookie_session = "sessao_graopara";
	public static final String cookie_nome = "nome_graopara";
	public static final String cookie_status = "status_graopara";
	public static final String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}; 
	
	public static ProfileDTO admin_profile = new ProfileDTO("admin", true, true, true);
	public static ProfileDTO user_profile = new ProfileDTO("user", true, true, false);
	public static ProfileDTO default_profile = new ProfileDTO("default", false, true, false);
	
	public static final int cookie_expire = -1; //1 sessão dias
	
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
	
	public static String printSelectOrigem(HttpServletRequest request) throws IOException, UnreachableDataBaseException {
		String output = null;
		
		OrigemDAO origemDAO = null;
		
		try {
			origemDAO = new OrigemDAO();
			List<DTO> list = origemDAO.findAllOrigins();
			List<String> aux = new ArrayList<String>();
			output = "\n	<option selected value=\"\">Selecione...</option> ";
			
			for(DTO d : list){
				String tipoOrigem = ((OrigemDTO) d).getTipoOrigem();
				if(!aux.contains(tipoOrigem)){
					output += "\n	<option value=\"" 
						+ tipoOrigem + " \">" 
						+ tipoOrigem + "</option> ";
					aux.add(tipoOrigem);
				}
			}
		} catch (OriginNotFoundException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static String printCadastroOrigem(HttpServletRequest request) throws IOException, UnreachableDataBaseException {
		String output = null;
		String identificacao = request.getParameter("identificacao");
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		
		OrigemDAO origemDAO = null;
		
		try {
			origemDAO = new OrigemDAO();
			List<DTO> list = origemDAO.findAllOrigins();
			if(identificacao != null && codigo != null && titulo != null)
				output = "\n	<option selected value=\"" 
						+ identificacao + "-" + codigo + "-" + titulo + "\">" 
						+ identificacao + " - " + codigo + " - " + titulo + "</option> ";
			
			else	output = "\n	<option selected value=\"\">Selecione...</option> ";
			for(DTO d : list){
				String tipoOrigem = ((OrigemDTO) d).getTipoOrigem();
				String codOrigem =  ((OrigemDTO) d).getCodOrigem();
				String tituloOrigem = ((OrigemDTO) d).getTitulo();
				if(!tipoOrigem.equals(identificacao) && !codOrigem.equals(codigo))
					output += "\n	<option value=\"" 
						+ tipoOrigem + "-" + codOrigem + "-" + tituloOrigem + " \">" 
						+ tipoOrigem + " - " + codOrigem + " - " + tituloOrigem + "</option> ";
			}
		} catch (OriginNotFoundException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static String printSelectId(HttpServletRequest request) throws IOException {
		String output = null;
		String parameter = request.getParameter("tipoAPEP_SEQ");
		if(parameter == null)
		{
			output = "<option value=\"\">\"Erro\"</option>";
		}
		else if(parameter.equals("APEP"))
		{
			output = 
					"<option selected value=\"APEP\">APEP</option> " +
					"<option value=\"SEQ\">Sequencial</option>";
		}
		else if(parameter.equals("SEQ"))
		{
			output = 
					"<option value=\"APEP\">APEP</option> " +
					"<option selected value=\"SEQ\">Sequencial</option>";
		}
		return output;
	}
	
	public static String printSelectDia(HttpServletRequest request) {
		String dia = request.getParameter("dia");
		return "<option selected value=\"" + dia + "\">" + dia + "</option>" +
				"<option value=\"\">--------</option>";
	}
	
	public static String printSelectMes(HttpServletRequest request) {
		String mes = request.getParameter("mes");
		int num_mes = Integer.parseInt(mes);
		return "<option selected value=\"" + mes + "\">" + meses[num_mes - 1] + "</option>" +
				"<option value=\"\">--------</option>";
	}
	
	public static String printSelectTipoDoc(HttpServletRequest request) {
		DocumentTypeDAO dtd = new DocumentTypeDAO();
		String result = "";
		String tipoDoc = null;
		try {
			List<DTO> list = dtd.findAllDocumentTypes();
			result = "<option value=\"\">Selecione...</option> ";
			for(DTO d : list){
				tipoDoc = ((TipoDocumentoDTO) d).getTipoDocumento();
				if(tipoDoc.equals(request.getParameter("tipoDoc")))
					result += "<option selected value=\"" + tipoDoc + "\">" + tipoDoc + "</option> ";
				else
					result += "<option value=\"" + tipoDoc + "\">" + tipoDoc + "</option> ";
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (DocumentTypeNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String printInputKeyWords(HttpServletRequest request, String key_pos) {
		BuscaPalavraChaveEJB busca = new BuscaPalavraChaveEJB();
		String result = "";
		String key = request.getParameter(key_pos);
		try {
			PalavraChaveDTO palavra = busca.buscarPalavraChave(key);
			return "<input type=\"text\" size=\"12\" maxlength=\"32\" class=\"inputPalavraChave\" id=\""+ key_pos +"\" name=\""+ key_pos +"\" value=\"" + palavra.getPalavra() + "\"/>";
			
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			return "<input type=\"text\" size=\"12\" maxlength=\"32\" class=\"inputPalavraChave\" id=\""+ key_pos +"\" name=\""+ key_pos +"\" value=\"\"></input> ";
		} catch (IllegalArgumentException e){
			return "<input type=\"text\" size=\"12\" maxlength=\"32\" class=\"inputPalavraChave\" id=\""+ key_pos +"\" name=\""+ key_pos +"\" value=\"\"></input> ";
		}
		return result;
	}
	
	public static String printSelectKeyWords(HttpServletRequest request, String key_pos) {
		KeyWordDAO word = new KeyWordDAO();
		String result = "";
		String key = null;
		try {
			List<DTO> list = word.getAllKeys();
			
			for(DTO d : list){
				key = ((PalavraChaveDTO) d).getPalavra();
				if(key.equals(request.getParameter(key_pos)))
					result += "<option selected value=\"" + key + "\">" + key + "</option> ";
				else
					result += "<option value=\"" + key + "\">" + key + "</option> ";
			}
		} catch (UnreachableDataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			// TODO Auto-generated catch block
		}
		return result;
	}
	
	public static String printOriginTitle(HttpServletRequest request) throws OriginNotFoundException {
		OrigemDAO od = new OrigemDAO();
		String result = "";
		try {
			OrigemDTO ori = od.findExactOrigin(request.getParameter("codigo"), request.getParameter("identificacao"));
			result = ori.getTitulo().trim();
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (OriginNotFoundException e) {
			throw e;
		}
		return result;
	}
	
	public static String removeAccents(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[^\\p{ASCII}]", "");
	    return str;
	}
}
