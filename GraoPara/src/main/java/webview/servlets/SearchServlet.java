package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import webview.WebUtility;

import business.EJB.docEJB.BuscaDocEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/doSearch")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String identificacao = request.getParameter("identificacao");
		String codigo = request.getParameter("codigo");
		String tipoAPEP_SEQ = request.getParameter("tipoAPEP_SEQ");
		String numAPEP = request.getParameter("numeroAPEP");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String data = request.getParameter("dataDocumento");
		String tipoDoc = request.getParameter("tipoDoc");
		String palavraChave1 = request.getParameter("chave1");
		String palavraChave2 = request.getParameter("chave2");
		String palavraChave3 = request.getParameter("chave3");
		String titulo = request.getParameter("titulo");
		Cookie cookie_status = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_status);
		int c_status;
		if(cookie_status == null) c_status = 0;
		else c_status = Integer.parseInt(cookie_status.getValue());

		List<DTO> resultados;
		BuscaDocEJB busca = new BuscaDocEJB();

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			resultados = busca.busca(identificacao, codigo, titulo, tipoAPEP_SEQ,
					numAPEP, autor, destinatario, local, data, tipoDoc,
					palavraChave1, palavraChave2, palavraChave3);
			for (DTO result : resultados) {
				out.println(WebUtility.docToString((DocumentoDTO) result));
				out.println("<br>------------------------------------------------------<br>");
			}

		} catch (UnreachableDataBaseException e) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde. ');");
			switch (c_status) {
			case 0:
				out.println("document.location=('/GraoPara/public/index.jsp');");
				break;

			case 1:
				out.println("document.location=('/GraoPara/protected/user/indexUser.jsp');");
				break;

			case 2:
				out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");
				break;
			}
			out.println("</script>");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Nenhuma documento corresponde a sua pesquisa. Verifique os dados e tente novamente. ');");
			switch (c_status) {
			case 0:
				out.println("document.location=('/GraoPara/public/pesquisa.jsp');");
				break;

			case 1:
				out.println("document.location=('/GraoPara/protected/user/pesquisaUser.jsp');");
				break;

			case 2:
				out.println("document.location=('/GraoPara/protected/admin/pesquisaAdmin.jsp');");
				break;
			}
			out.println("</script>");
			e.printStackTrace();
		}
	}

}
