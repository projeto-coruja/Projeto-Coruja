package webview.servlet.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.Documento;
import webview.util.AlertsUtility;
import business.EJB.documents.DocumentEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class DocRemovalServlet
 */
@WebServlet("/protected/admin/removeDoc")
public class DocRemovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocRemovalServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("codigo"); // Número APEP/SEQ
		DocumentEJB docEJB = new DocumentEJB();
		response.setContentType("text/html; charset=UTF-8");  
	    Documento docs = null;
		try {
			docs = docEJB.findSingleDocument(code);
			docEJB.removeDocument(docs);
			AlertsUtility.alertAndRedirectPage(response, "Documento removido com sucesso.",request.getHeader("referer"));
		} catch (UnreachableDataBaseException e) {
			AlertsUtility.alertAndRedirectPage(response, "Erro no banco de dados.", "index.jsp");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			e.printStackTrace();
		}
	}

}
