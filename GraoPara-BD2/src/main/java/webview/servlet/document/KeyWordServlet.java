package webview.servlet.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;
import webview.util.AlertsUtility;
import business.EJB.documents.KeyWordEJB;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.documents.ThemeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class KeyWordServlet
 */
@WebServlet(urlPatterns={"/protected/admin/doChangesToKeyWord", "/protected/userAdv/doChangesToKeyWord"})
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
		KeyWordEJB cad = new KeyWordEJB();
		String oldKey = request.getParameter("palavraAntiga");
		String newKey = request.getParameter("palavraNova");
		String theme = request.getParameter("tema");
		String action = request.getParameter("action");
		
		try {
			if(action!= null && action.equals("add")) {
				cad.addKeyWord(newKey.toLowerCase(), theme);
				AlertsUtility.alertAndRedirectPage(response, "Palavra chave adicionada com sucesso.","cadastrarPalavrasChave.jsp");
			}
			else if(action!= null && action.equals("edit")) {
				cad.updateKeyWord(oldKey, newKey.toLowerCase(), theme);
				AlertsUtility.alertAndRedirectPage(response, "Palavra chave atualizada com sucesso.","cadastrarPalavrasChave.jsp");
			}
			else if(action != null && action.equals("delete")) {	
				cad.removeKeyWord(oldKey);
				AlertsUtility.alertAndRedirectPage(response, "Palavra chave excluída com sucesso.","cadastrarPalavrasChave.jsp");
			}
			else {
				AlertsUtility.alertAndRedirectHistory(response, "Problema ao executar operação.");
			}
		} catch (UnreachableDataBaseException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro no banco de dados! Contate o suporte e tente novamente mais tarde.");
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Palavra chave já existe ou argumento inválido.");
		} catch (UpdateEntityException e) {
			e.printStackTrace();
		} catch (ThemeNotFoundException e) {
			e.printStackTrace();
		}
	}
}
