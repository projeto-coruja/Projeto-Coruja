package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.PalavraChaveDTO;

import business.EJB.docEJB.BuscaPalavraChaveEJB;
import business.EJB.docEJB.CadastroEJB;
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
		String key = request.getParameter("palavra");
		String action = request.getParameter("action");
		String previous = request.getParameter("tab");
		
		try {
			if(action.equals("approve")) 
				cad.aprovarPalavraChave(key);
			else if(action.equals("delete"))	
				cad.deletarPalavraChave(key);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("/GraoPara/protected/admin/painelAdmin.jsp#tab"+previous);
	}
}
