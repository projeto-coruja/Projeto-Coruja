package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.docEJB.TipoDocumentoEJB;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class DocTypeServlet
 */
@WebServlet("/protected/admin/doDocType")
public class DocTypeServlet extends HttpServlet {;
       
	private static final long serialVersionUID = 838811728644465716L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DocTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("docType");
		TipoDocumentoEJB tdEjb = new TipoDocumentoEJB();
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		try {
			tdEjb.addNewDocumentType(tipo);
			out.println("<script>");  
		    out.println("document.location=('/GraoPara/protected/admin/cadastrarTipoDocumento.jsp');");
		    out.println("</script>");
		} catch (UnreachableDataBaseException e) {
			out.println("<script>");  
		    out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde.');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		}
		
	}

}
