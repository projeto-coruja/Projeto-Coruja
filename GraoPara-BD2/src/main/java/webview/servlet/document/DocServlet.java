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
@WebServlet(urlPatterns={"/protected/admin/addDoc", "/protected/user/addDoc"})
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tituloDocumento = request.getParameter("tituloDocumento");
		String tipoCodDocumento = request.getParameter("tipoDoc");
		String codDocumento = request.getParameter("numero");		
		String local = request.getParameter("local");
		String url = request.getParameter("urlImagem");
		String resumo = request.getParameter("resumo");
		
		String[] identificacao = request.getParameter("identificacao").split("-");
		String tipoCodiceCaixa = identificacao[0];
		String codCodiceCaixa = identificacao[1];
		String tituloCodiceCaixa = identificacao[2];		
		String anoInicioCodiceCaixa = request.getParameter("anoInicioCodiceCaixa");
		String anoFimCodiceCaixa = request.getParameter("anoFimCodiceCaixa");
		
		String autor = request.getParameter("autor");
		String ocupacaoAutor = request.getParameter("autorOcupacao");
		
		String destinatario = request.getParameter("destinatario");
		String ocupacaoDestinatario = request.getParameter("destinatarioOcupacao");
		
		String tipoDocumento = request.getParameter("tipoDoc");
		String descricaoDoTipoDocumento = request.getParameter("descricaoTipoDocumento");
		
		String palavraChave1 = request.getParameter("chave1");
		String palavraChave2 = request.getParameter("chave2");
		String palavraChave3 = request.getParameter("chave3");
		
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		

		String data = request.getParameter("ano") + "-" + request.getParameter("mes") + "-" + request.getParameter("dia");
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
			codDocumento = tipoCodDocumento+"-"+codDocumento;
			try {
				
				CB.registerNewDocument(tituloDocumento, 
						tipoCodDocumento,
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
						palavraChave2, 
						palavraChave3);
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
				out.println("window.location.replace('/GraoPara/protected/user/index.jsp');");  
				out.println("</script>");
				e.printStackTrace();
			} catch (IllegalArgumentException e){
				e.printStackTrace();
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
			    out.println("<script>");  
			    out.println("alert('Rá');");  
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
