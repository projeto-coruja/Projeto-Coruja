package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.docEJB.CadastroEJB;
import business.exceptions.documents.OriginNotFoundException;
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
		String tipo = request.getParameter("identificacao");
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		
		CadastroEJB cb = new CadastroEJB();
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();   

		try {
			cb.atualizarTituloOrigem(tipo, codigo, titulo);
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
		} catch (OriginNotFoundException e) {
			out.println("<script>");  
		    out.println("alert('Argumento interno ilegal, contate o suporte." + e.getStackTrace() + "');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		}
	}

}
