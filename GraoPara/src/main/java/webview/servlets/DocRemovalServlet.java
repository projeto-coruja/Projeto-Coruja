package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.DocumentoDTO;
import business.EJB.docEJB.BuscaDocEJB;
import business.EJB.docEJB.CadastroEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class DocRemovalServlet
 */
@WebServlet("/protected/admin/removeDoc")
public class DocRemovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocRemovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoAPEP_SEQ = request.getParameter("tipoAPEP_SEQ");
		String numAPEP_SEQ = request.getParameter("numeroAPEP");
		BuscaDocEJB search = new BuscaDocEJB();
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter(); 
	    DocumentoDTO docs = null;
		CadastroEJB delete = new CadastroEJB();
		try {
			docs = search.busca(tipoAPEP_SEQ, numAPEP_SEQ);
			delete.deletarDocumento(docs);
			response.sendRedirect(request.getHeader("referer"));
			response.setHeader("Refresh", "0");
		} catch (UnreachableDataBaseException e) {
		    out.println("<script>");  
		    out.println("alert('Erro no banco de dados. ');");  
		    out.println("document.location=('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e){
		    out.println("<script>");  
		    out.println("alert('"+ e.getMessage() +" ');");  
		    out.println("document.location=('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
		}
	}

}
