package webview.servlet.document;

import static webview.util.WebUtility.isInit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;

import webview.util.AlertsUtility;
import business.EJB.documents.CodiceCaixaEJB;
import business.EJB.util.QuickRegex;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;



/**
 * Servlet implementation class OriginServlet
 */
@WebServlet("/protected/admin/editOrigin")
public class EditOriginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int max = 2012;
       
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String strAnoIni = request.getParameter("anoIni");
		String strAnoFim = request.getParameter("anoFim");
		CodiceCaixaEJB cb = new CodiceCaixaEJB();
		
		if(!(isInit(codigo) && isInit(titulo) && isInit(strAnoIni) && isInit(strAnoFim))) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro: campos estão vazios!");
		}
		else if(QuickRegex.findAN(titulo) || QuickRegex.findN(strAnoFim) || QuickRegex.findN(strAnoIni)){
			AlertsUtility.alertAndRedirectHistory(response, "Erro: caracteres inválidos!");
		}
		else {
			int anoIni = Integer.parseInt(strAnoIni);
			int anoFim = Integer.parseInt(strAnoFim);
			if(anoIni > anoFim) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro: ano de ínicio maior que de fim!");
			}
			else if(anoIni > max || anoFim > max) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro: ano inválido!");
			}
			else try {
				cb.update(codigo, titulo, anoIni, anoFim);
				AlertsUtility.redirectOnly(response, "/GraoPara/protected/admin/cadastrarOrigem.jsp");
			} catch (UnreachableDataBaseException e) {
				AlertsUtility.alertAndRedirectPage(response, "Erro no banco de dados, contate o suporte e tente novamente mais tarde.", "/GraoPara/protected/admin/adminIndex.jsp");
			} catch (IllegalArgumentException e) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro: valores inválidos!");
			} catch (CodiceCaixaNotFoundException e) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro interno no servidor, contate o suporte!");
				e.printStackTrace();
			} catch (UpdateEntityException e) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro interno no servidor, contate o suporte!");
				e.printStackTrace();
			}
		}	
	}
}
