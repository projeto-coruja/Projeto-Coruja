package webview.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;

import business.EJB.documents.CodiceCaixaEJB;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class CodexServlet
 */
@WebServlet("/listCodex")
public class CodexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Lista de códices e/ou caixas com conteúdo: <br>");
		CodiceCaixaEJB cb = new CodiceCaixaEJB();
		try {
			List<DTO> list = cb.getAllEntriesWithContent();
			for(DTO d : list) {
				CodiceCaixa work = (CodiceCaixa) d;
				out.println("&#183" + work.getTitulo() + " - " + work.getAnoInicio() + "/" + work.getAnoFim() + "<br>");
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (CodiceCaixaNotFoundException e) {

		}
	}

}
