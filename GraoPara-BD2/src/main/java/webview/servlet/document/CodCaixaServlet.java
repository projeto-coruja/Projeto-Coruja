package webview.servlet.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.documents.CodiceCaixaEJB;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class OriginServlet
 */
@WebServlet("/protected/admin/addOrigin")
public class CodCaixaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodCaixaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		int anoIni = Integer.parseInt(request.getParameter("anoIni"));
		int anoFim = Integer.parseInt(request.getParameter("anoFim"));
		
		CodiceCaixaEJB od = new CodiceCaixaEJB();
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();   

		try {
			od.add(tipo, codigo, titulo, anoIni, anoFim);
			out.println("<script>");  
		    out.println("window.location.replace('/GraoPara/protected/admin/cadastrarOrigem.jsp');");
		    out.println("</script>");		
		} catch (DuplicateCodiceCaixaException e) {
			out.println("<script>");  
			out.println("alert('Número de Códices/Caixas Já Existe.');");  
		    out.println("history.go(-1);");  
		    out.println("</script>");
		    e.printStackTrace();
		} catch (UnreachableDataBaseException e) {
			out.println("<script>");  
			out.println("alert('Erro no banco de dados, contate o suporte e tente novamente mais tarde.');");
		    out.println("window.location.replace('/GraoPara/protected/admin/adminIndex.jsp');");
		    out.println("</script>");
		}
	}

}
