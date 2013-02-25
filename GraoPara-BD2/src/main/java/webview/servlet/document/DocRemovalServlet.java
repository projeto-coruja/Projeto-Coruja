package webview.servlet.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.Documento;

import business.EJB.documents.DocumentEJB;
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
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("tipo"); // Tipo APEP/SEQ
		String code = request.getParameter("numero"); // Número APEP/SEQ
		DocumentEJB docEJB = new DocumentEJB();
		response.setContentType("text/html; charset=UTF-8");  
	    PrintWriter out=response.getWriter(); 
	    Documento docs = null;
		try {
			docs = docEJB.findSingleDocument(type, String.format("%04d", Integer.parseInt(code)));
			docEJB.removeDocument(docs);
			response.sendRedirect(request.getHeader("referer"));
			response.setHeader("Refresh", "0");
		} catch (UnreachableDataBaseException e) {
		    out.println("<script>");  
		    out.println("alert('Erro no banco de dados. ');");  
		    out.println("window.location.replace('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e){
		    out.println("<script>");  
		    out.println("alert('"+ e.getMessage() +" ');");  
		    out.println("window.location.replace('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
		}
	}

}
