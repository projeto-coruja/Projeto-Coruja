package webview.servlet.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;

import business.EJB.documents.CodiceCaixaEJB;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class OriginServlet
 */
@WebServlet("/protected/admin/editOrigin")
public class EditOriginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOriginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldCod = null;
		String oldTitle = null;
		String newCod = null;
		String newTitle = null;
		int anoInicio = 0;
		int anoFim = 0;
		
		CodiceCaixaEJB cb = new CodiceCaixaEJB();
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();   

		try {
			cb.update(oldCod, oldTitle, newCod, newTitle, anoInicio, anoFim);
			out.println("<script>");  
		    out.println("alert('Título editado com sucesso.');");
		    out.println("document.location=('/GraoPara/protected/admin/cadastrarOrigem.jsp');");
		    out.println("</script>");		
		} catch (UnreachableDataBaseException e) {
			out.println("<script>");  
		    out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde." + e.getStackTrace() + "');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
		    e.printStackTrace();
		} catch (IllegalArgumentException e) {
			out.println("<script>");  
		    out.println("alert('Argumento interno ilegal, contate o suporte." + e.getStackTrace() + "');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (CodiceCaixaNotFoundException e) {
			out.println("<script>");  
		    out.println("alert('Argumento interno ilegal, contate o suporte." + e.getStackTrace() + "');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
			e.printStackTrace();
		} catch (UpdateEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
