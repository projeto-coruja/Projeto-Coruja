package webview.servlet.document;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.AlertsUtility;
import business.EJB.documents.CodiceCaixaEJB;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class OriginServlet
 */
@WebServlet(urlPatterns={"/protected/admin/addOrigin", "/protected/userAdv/addOrigin", "/protected/user/addOrigin" })
public class CodCaixaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean isInit(String s) {
		return s != null && !s.isEmpty();
	}
	
	private static Pattern p = Pattern.compile("[^a-z0-9áãâéêíóõôúç]", Pattern.CASE_INSENSITIVE & Pattern.UNICODE_CASE);
	private static Pattern q = Pattern.compile("[^0-9]");
       
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
		
		if(isInit(tipo) && isInit(codigo) && isInit(titulo) && isInit(strAnoIni) && isInit(strAnoFim)) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro: campos estão vazios!");
		}
		else if(q.matcher(codigo).find() || p.matcher(titulo).find() || q.matcher(strAnoFim).find() || q.matcher(strAnoIni).find()){
			AlertsUtility.alertAndRedirectHistory(response, "Erro: caracteres inválidos!");
		}
		else {
			int anoIni = Integer.parseInt(strAnoIni);
			int anoFim = Integer.parseInt(strAnoFim);
			if(anoIni > anoFim) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro: ano de ínicio maior que de fim!");
			}
			else try {
				od.add(tipo, codigo, titulo, anoIni, anoFim);
				AlertsUtility.redirectOnly(response, "/GraoPara/protected/admin/cadastrarOrigem.jsp");
			} catch (DuplicateCodiceCaixaException e) {
				AlertsUtility.alertAndRedirectHistory(response, "Número de códices/caixas já existe.");
				e.printStackTrace();
			} catch (UnreachableDataBaseException e) {
				AlertsUtility.alertAndRedirectPage(response, "Erro no banco de dados, contate o suporte e tente novamente mais tarde.", "/GraoPara/protected/admin/adminIndex.jsp");
			}
		}
	}
}
