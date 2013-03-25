package webview.servlet.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.AlertsUtility;
import business.EJB.documents.DocumentTypeEJB;
import business.exceptions.documents.DuplicatedDocumentTypeException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class DocTypeServlet
 */
@WebServlet(urlPatterns={"/protected/admin/doDocType", "/protected/userAdv/doDocType"})
public class DocTypeServlet extends HttpServlet {;
       
	private static final long serialVersionUID = 838811728644465716L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DocTypeServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("docType");
		String descricao = request.getParameter("docTypeDescription");
		DocumentTypeEJB tdEjb = new DocumentTypeEJB();
		response.setContentType("text/html; charset=UTF-8");  
		try {
			tdEjb.addNewDocumentType(tipo, descricao);
			AlertsUtility.alertAndRedirectPage(response, "Tipo adicionado com sucesso.", "cadastrarTipoDocumento.jsp");
		} catch (UnreachableDataBaseException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro no banco de dados! Contate o suporte e tente novamente mais tarde.");
			e.printStackTrace();
		} catch (DuplicatedDocumentTypeException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Tipo de documento já existe.");
		}		
	}
}
