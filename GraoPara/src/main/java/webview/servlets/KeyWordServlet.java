package webview.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.docEJB.CadastroEJB;
import business.EJB.util.EJBUtility;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class KeyWordServlet
 */
@WebServlet("/doChangesToKeyWord")
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
		
		CadastroEJB cad = new CadastroEJB();
		String key = request.getParameter(EJBUtility.getHash("palavra", "SHA-256"));
		String action = request.getParameter(EJBUtility.getHash("action", "SHA-256"));
		String previous = request.getParameter("tab");
		
		try {
			if(action.equals(EJBUtility.getHash("approve", "SHA-256"))) cad.atualizarPalavraChave(key, key, true);
			else if(action.equals(EJBUtility.getHash("delete", "SHA-256")))	cad.deletarPalavraChave(key);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("/GraoPara/protected/admin/painelAdmin.jsp#tab"+previous);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
