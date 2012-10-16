package webview.servlet.document;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.UserAccount;

import webview.util.WebUtility;
import business.EJB.documents.DocumentEJB;
import business.EJB.user.SearchUserBean;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Servlet implementation class DocServlet
 */
@WebServlet(urlPatterns={"/protected/user/addDoc", "/protected/admin/addDoc"})
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tituloDocumento = null;
		String codDocumento = null;
		String local = null;
		String url = null;
		String resumo = null;
		String data = null;
		String tipoCodiceCaixa = null;
		String codCodiceCaixa = null;
		String tituloCodiceCaixa = null;
		String anoInicioCodiceCaixa = null;
		String anoFimCodiceCaixa = null;
		String autor = null;
		String ocupacaoAutor = null;
		String destinatario = null;
		String ocupacaoDestinatario = null;
		String tipoDocumento = null;
		String descricaoDoTipoDocumento = null;
		String palavraChave1 = null;
		String temaPalavraChave1 = null;
		String palavraChave2 = null;
		String temaPalavraChave2 = null;
		String palavraChave3 = null;
		String temaPalavraChave3 = null;
		
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		
//		GregorianCalendar dataDoc = new GregorianCalendar(Integer.parseInt(dataAno), Integer.parseInt(dataMes), Integer.parseInt(dataDia));
		Date dataDoc = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			dataDoc = (Date) df.parse(data);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		UserAccount uploader = null;
		try {
			uploader = (new SearchUserBean()).findUser(email);
			DocumentEJB CB = new DocumentEJB();
			codCodiceCaixa = tipoCodiceCaixa+"-"+codCodiceCaixa;
			try {
				
				CB.registerNewDocument(tituloDocumento, 
						codDocumento, 
						local, 
						url,
						resumo, 
						dataDoc,
						uploader, 
						codCodiceCaixa, 
						tituloCodiceCaixa, 
						anoInicioCodiceCaixa, 
						anoFimCodiceCaixa, 
						autor, 
						ocupacaoAutor, 
						destinatario, 
						ocupacaoDestinatario, 
						tipoDocumento, 
						descricaoDoTipoDocumento, 
						palavraChave1, 
						temaPalavraChave1, 
						palavraChave2, 
						temaPalavraChave2, 
						palavraChave3, 
						temaPalavraChave3);
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
			    out.println("<script>");  
			    out.println("alert('Documento adicionado com sucesso!');");  
			    out.println("history.go(-1);");  
			    out.println("</script>");
			} catch (UnreachableDataBaseException e) {
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
				out.println("<script>");  
				out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde." + e.getStackTrace() + "');");  
				out.println("document.location=('/GraoPara/protected/user/indexUser.jsp');");  
				out.println("</script>");
				e.printStackTrace();
			} catch (IllegalArgumentException e){
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
			    out.println("<script>");  
			    out.println("alert('Problema ao cadastrar documento, Já existe documento com a identificação fornecido!');");  
			    out.println("history.go(-1);");  
			    out.println("</script>");
			}
		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnreachableDataBaseException e1) {
			e1.printStackTrace();
		}
	}

}
