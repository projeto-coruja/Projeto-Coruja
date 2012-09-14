package webview.servlets;

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

import webview.WebUtility;
import business.EJB.docEJB.CadastroEJB;
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
		String tipoOrigem = request.getParameter("identificacao");
		String tipoId = request.getParameter("tipo_num").toUpperCase();
		String numId = request.getParameter("numero");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String dataDia = request.getParameter("dia");
		String dataMes = request.getParameter("mes");
		String dataAno = request.getParameter("ano");
		String tipoDoc = request.getParameter("tipoDoc");
		String resumo = request.getParameter("resumo");
		String palChave1 = request.getParameter("chave1");
		String palChave2 = request.getParameter("chave2");
		String palChave3 = request.getParameter("chave3");
		
		String tipoIdAntigo = request.getParameter("pesquisa_APEP_SEQ");
		String numIdAntigo = request.getParameter("pesquisa_num_APEP_SEQ");

		String codOrigem = tipoOrigem.split("-")[1] ;
		String titulo = tipoOrigem.split("-")[2];
		tipoOrigem = tipoOrigem.split("-")[0].toUpperCase();
		
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		
//		GregorianCalendar dataDoc = new GregorianCalendar(Integer.parseInt(dataAno), Integer.parseInt(dataMes), Integer.parseInt(dataDia));
		Date dataDoc = null;
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		try {
			dataDoc = (Date) df.parse(dataAno+"-"+dataMes+"-"+dataDia);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		CadastroEJB CB = new CadastroEJB();

		
		try {
			CB.atualizarDocumento(codOrigem, tipoOrigem, titulo, 
					tipoIdAntigo, numIdAntigo, tipoId, numId,
					tipoDoc,
					palChave1, palChave2, palChave3,
					autor, local, destinatario, resumo,
					dataDoc, email);
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
		}
    }
}

