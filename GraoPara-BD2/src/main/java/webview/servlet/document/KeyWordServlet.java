package webview.servlet.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;
import business.EJB.documents.KeyWordEJB;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");  
	    PrintWriter out=response.getWriter();   
		KeyWordEJB cad = new KeyWordEJB();
		String oldKey = request.getParameter("palavraAntiga");
		String newKey = request.getParameter("palavraNova");
		String theme = request.getParameter("tema");
		String action = request.getParameter("action");
		
		try {
			if(action!= null && action.equals("add")) {
				cad.addKeyWord(newKey.toLowerCase(), theme);
			    out.println("<script>");  
			    out.println("alert('Palavra chave adicionada com sucesso. ');");  
			    out.println("window.location.replace('/GraoPara/protected/admin/cadastrarPalavrasChave.jsp');");
			    out.println("</script>");
			}
			else if(action!= null && action.equals("edit")) {
				cad.updateKeyWord(oldKey, newKey.toLowerCase(), theme);
			    out.println("<script>");  
			    out.println("alert('Palavra chave atualizada com sucesso. ');");
			    out.println("window.location.replace('/GraoPara/protected/admin/cadastrarPalavrasChave.jsp');");
			    out.println("</script>");
			}
			else if(action != null && action.equals("delete")) {	
				cad.removeKeyWord(oldKey);
			    out.println("<script>");
			    out.println("alert('Palavra chave excluída com sucesso. ');");
			    out.println("window.location.replace('/GraoPara/protected/admin/cadastrarPalavrasChave.jsp');");
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
		    out.println("alert('Palavra chave já existe ou argumento inválido.');");  
		    out.println("history.go(-1);");  
		    out.println("</script>");
		} catch (UpdateEntityException e) {
			e.printStackTrace();
		}
	}
}
