package webview.servlet.document;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;
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

    	String tipoCodDocumentoAntigo = request.getParameter("pesquisa_APEP_SEQ");
		String codDocumentoAntigo = request.getParameter("pesquisa_num_APEP_SEQ");
		
		String tituloDocumento = request.getParameter("tituloDocumento");
		String tipoCodDocumento = request.getParameter("tipo_num");
		String codDocumento = request.getParameter("numero");
		String local = request.getParameter("local");
		String url = request.getParameter("urlImagem");
		String resumo = request.getParameter("resumo");
		
		String[] identificacao = request.getParameter("identificacao").split("-");
		String tipoCodiceCaixa = identificacao[0];
		String codCodiceCaixa = identificacao[1];
		
		String autor = request.getParameter("autor");
		String ocupacaoAutor = request.getParameter("autorOcupacao");
		
		String destinatario = request.getParameter("destinatario");
		String ocupacaoDestinatario = request.getParameter("destinatarioOcupacao");
		
		String tipoDocumento = request.getParameter("tipoDoc");
		
		String palavraChave1 = request.getParameter("chave1");
		String palavraChave2 = request.getParameter("chave2");
		String palavraChave3 = request.getParameter("chave3");
    	
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		

		String data = request.getParameter("ano") + "-" + request.getParameter("mes") + "-" + request.getParameter("dia");
		Date dataDoc = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			dataDoc = (Date) df.parse(data);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		DocumentEJB CB = new DocumentEJB();
		codCodiceCaixa = tipoCodiceCaixa+"-"+codCodiceCaixa;
		codDocumento = tipoCodDocumento+"-"+codDocumento;
		
		try {
			CB.modifyDocument(tipoCodDocumentoAntigo,
					codDocumentoAntigo, 
					tituloDocumento, 
					tipoCodDocumento,
					codDocumento, 
					local, 
					url, 
					resumo, 
					dataDoc, 
					codCodiceCaixa, 
					autor, 
					ocupacaoAutor, 
					destinatario, 
					ocupacaoDestinatario, 
					tipoDocumento, 
					palavraChave1,
					palavraChave2, 
					palavraChave3);
			out.println("<script>");  
			out.println("alert('Documento Atualizado com sucesso!');");  
			out.println("window.location.replace('/GraoPara/protected/admin/index.jsp');");  
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

