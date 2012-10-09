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

import persistence.exceptions.UpdateEntityException;

import webview.util.WebUtility;
import business.EJB.documents.DocumentEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class DocUpdateServlet
 */
@WebServlet("/protected/admin/updateDoc")
public class DocUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String codDocumentoAntigo = null;
		String tituloDocumento = null;
		String codDocumento = null;
		String local = null;
		String resumo = null;
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
    	
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		
//		GregorianCalendar dataDoc = new GregorianCalendar(Integer.parseInt(dataAno), Integer.parseInt(dataMes), Integer.parseInt(dataDia));
		Date dataDoc = null;
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		try {
			dataDoc = (Date) df.parse("-");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		DocumentEJB CB = new DocumentEJB();

		
		try {
			CB.modifyDocument(codDocumentoAntigo, 
					tituloDocumento, 
					codDocumento, 
					local, 
					resumo, 
					dataDoc, 
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
			out.println("<script>");  
			out.println("alert('Documento Atualizado com sucesso!');");  
			out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
			out.println("</script>");
		} catch (UnreachableDataBaseException e) {
			out.println("<script>");  
			out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde." + e.getStackTrace() + "');");  
			out.println("history.go(-1)");  
			out.println("</script>");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			out.println("<script>");  
			out.println("alert('Número APEP/Sequencial duplicado.');");  
			out.println("history.go(-1)");  
			out.println("</script>");
		} catch (UpdateEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

