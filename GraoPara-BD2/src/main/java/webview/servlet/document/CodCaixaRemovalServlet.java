package webview.servlet.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.AlertsUtility;

import business.EJB.documents.CodiceCaixaEJB;
import business.EJB.documents.DocumentEJB;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class CodCaixaRemovalServlet
 */
@WebServlet("/protected/admin/removeCodex")
public class CodCaixaRemovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodCaixaRemovalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");

		try {
			new DocumentEJB().findByCodiceCaixa(codigo);
			AlertsUtility.alertAndRedirectPage(response, "Erro: mude o coódice/caixa de todos os documentos que utlizam este e tente remover novamente!", "cadastrarOrigem.jsp");
		} catch (UnreachableDataBaseException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro no banco de dados, contate o suporte!");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			try {
				new CodiceCaixaEJB().deleteCodCaixa(codigo);
				AlertsUtility.alertAndRedirectPage(response, "Códice ou caixa removido(a) com sucesso!", "cadastrarOrigem.jsp");
			} catch (UnreachableDataBaseException e1) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro no banco de dados, contate o suporte!");
				e1.printStackTrace();
			} catch (CodiceCaixaNotFoundException e1) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro interno do servidor, contate o suporte!");
				e1.printStackTrace();
			}
		}
	}
}
