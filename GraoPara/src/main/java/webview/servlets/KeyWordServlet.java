package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.docEJB.CadastroEJB;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class KeyWordServlet
 */
@WebServlet("/protected/admin/doChangesToKeyWord")
public class KeyWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeyWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		CadastroEJB cad = new CadastroEJB();
		String key = request.getParameter("palavra");
		String action = request.getParameter("action");
		String previous = request.getParameter("from");
		if(previous.equals("painelAdmin.jsp"))	previous += "#tab3";
		try {
			if(action!= null && action.equals("add")) {
				cad.cadastrarPalavraChave(key);
			    out.println("<script>");  
			    out.println("alert('Palavra chave adicionado com sucesso. ');");  
			    out.println("document.location=('/GraoPara/protected/admin/"+ previous +"');");
			    out.println("</script>");
			}
			else if(action != null && action.equals("delete")) {	
				cad.deletarPalavraChave(key);
			    out.println("<script>");
			    out.println("document.location=('/GraoPara/protected/admin/"+ previous+"');");
			    out.println("</script>");
			}
			else {
			    out.println("<script>");  
			    out.println("alert('Problema ao executar operação. ');");  
			    out.println("history.go(-1);");  
			    out.println("</script>");
			}
		} catch (UnreachableDataBaseException e) {
		    out.println("<script>");  
		    out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde. ');");  
		    out.println("history.go(-1);");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
