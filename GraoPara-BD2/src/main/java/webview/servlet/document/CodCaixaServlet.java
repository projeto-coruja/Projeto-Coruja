package webview.servlet.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.AlertsUtility;
import static webview.util.WebUtility.isInit;

import business.EJB.documents.CodiceCaixaEJB;
import business.EJB.util.QuickRegex;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class OriginServlet
 */
@WebServlet(urlPatterns={"/protected/admin/addOrigin", "/protected/userAdv/addOrigin", "/protected/user/addOrigin" })
public class CodCaixaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int max = 2012;
       
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
		
		String tipo = request.getParameter("tipo");
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String strAnoIni = request.getParameter("anoIni");
		String strAnoFim = request.getParameter("anoFim");
				
		if(!(isInit(tipo) && isInit(codigo) && isInit(titulo) && isInit(strAnoIni) && isInit(strAnoFim))) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro: campos estão vazios!");
		}
		else if(QuickRegex.findN(codigo) || QuickRegex.findAN(titulo) || QuickRegex.findN(strAnoFim) || QuickRegex.findN(strAnoIni)){
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
				od.add(tipo, codigo, titulo, anoIni, anoFim);
				AlertsUtility.redirectOnly(response, "cadastrarOrigem.jsp");
			} catch (DuplicateCodiceCaixaException e) {
				AlertsUtility.alertAndRedirectHistory(response, "Número de códices/caixas já existe.");
				e.printStackTrace();
			} catch (UnreachableDataBaseException e) {
				AlertsUtility.alertAndRedirectPage(response, "Erro no banco de dados, contate o suporte e tente novamente mais tarde.", "index.jsp");
			}
		}
	}
}
