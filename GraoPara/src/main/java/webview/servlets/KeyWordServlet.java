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
		String oldKey = request.getParameter("palavraAntiga");
		String newKey = request.getParameter("palavraNova");
		String action = request.getParameter("action");
		
		if(oldKey != null)	oldKey = oldKey.replace(" ", "_");
		if(newKey != null)	newKey = newKey.replace(" ", "_");
		
		try {
			if(action!= null && action.equals("add")) {
				cad.cadastrarPalavraChave(newKey);
			    out.println("<script>");  
			    out.println("alert('Palavra chave adicionado com sucesso. ');");  
			    out.println("document.location=('/GraoPara/protected/admin/cadastrarPalavrasChave.jsp');");
			    out.println("</script>");
			}
			else if(action!= null && action.equals("edit")) {
				cad.atualizarPalavraChave(oldKey, newKey, true);
			    out.println("<script>");  
			    out.println("alert('Palavra chave atualizada com sucesso. ');");
			    out.println("document.location=('/GraoPara/protected/admin/cadastrarPalavrasChave.jsp');");
			    out.println("</script>");
			}
			else if(action != null && action.equals("delete")) {	
				cad.deletarPalavraChave(oldKey);
			    out.println("<script>");
			    out.println("alert('Palavra chave excluída com sucesso. ');");
			    out.println("document.location=('/GraoPara/protected/admin/cadastrarPalavrasChave.jsp');");
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
		} catch (IllegalArgumentException e) {
			out.println("<script>");  
		    out.println("alert('Palavra chave já existe.');");  
		    out.println("history.go(-1);");  
		    out.println("</script>");
		}
	}
}
