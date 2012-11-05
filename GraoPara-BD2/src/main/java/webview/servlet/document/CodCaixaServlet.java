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
@WebServlet(urlPatterns={"/protected/admin/addOrigin", "/protected/userAdv/addOrigin", "/protected/user/addOrigin" })
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CodiceCaixaEJB od = new CodiceCaixaEJB();
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();  
		
		String tipo = request.getParameter("tipo");
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String strAnoIni = request.getParameter("anoIni");
		String strAnoFim = request.getParameter("anoFim");
		
		if(tipo.trim().isEmpty() || codigo.trim().isEmpty() || titulo.trim().isEmpty() || strAnoIni.trim().isEmpty() || strAnoFim.trim().isEmpty()) {
			out.println("<script>");  
			out.println("alert('Preencha todos os campos, por favor!');");  
		    out.println("history.go(-1);");  
		    out.println("</script>");
		}
		else {
			int anoIni = Integer.parseInt(strAnoIni);
			int anoFim = Integer.parseInt(strAnoFim);

			try {
				od.add(tipo, codigo, titulo, anoIni, anoFim);
				out.println("<script>");  
				out.println("window.location.replace('/GraoPara/protected/admin/cadastrarOrigem.jsp');");
				out.println("</script>");		
			} catch (DuplicateCodiceCaixaException e) {
				out.println("<script>");  
				out.println("alert('Número de códices/caixas já existe.');");  
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
}
