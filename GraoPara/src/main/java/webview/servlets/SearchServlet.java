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
import javax.servlet.jsp.JspWriter;

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
		String numAPEP_SEQ = request.getParameter("numeroAPEP");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String data = request.getParameter("dataDocumento");
		String tipoDoc = request.getParameter("tipoDoc");
		String palavra1 = request.getParameter("chave1");
		String palavra2 = request.getParameter("chave2");
		String palavra3 = request.getParameter("chave3");
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
//			for (DTO result : resultados) {
//				out.println(WebUtility.docToString((DocumentoDTO) result));
//				out.println("<br>------------------------------------------------------<br>");
//			}
			
			resultados = busca.busca(identificacao, codigo, titulo, tipoAPEP_SEQ, numAPEP_SEQ, autor, destinatario, local, data, tipoDoc, palavra1, palavra2, palavra3); 

			for(DTO d : resultados){
				
				DocumentoDTO doc = (DocumentoDTO) d;
				
				out.println("<tr>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTipoOrigem()+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getCodOrigem() +"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTitulo() 	+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getTipoId()		+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getCodId()		+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getAutor() 							+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getDestinatario()					+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getLocal()							+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getDataDocumento()					+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getTipoDocumento()					+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"
						+ doc.getPalavrasChaves1() + " - " 
						+ doc.getPalavrasChaves2() + " - "
						+ doc.getPalavrasChaves3() + " - "
						+ "</label></td>");
				out.println("<td>"
						+ "<a href=\"#\"><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\"/></a> "
						+ "<br>"
						+ "<a href=\"#\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/></a> "
						+ "</td>");
				out.println("</tr>");
			}
			response.sendRedirect("/GraoPara/protected/admin/listagemDocumentos.jsp");

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
	
	public static void listAllDocuments(HttpServletRequest request, JspWriter out) throws IOException{
		String identificacao = request.getParameter("identificacao");
		String codigo = request.getParameter("codigo");
		String tipoAPEP_SEQ = request.getParameter("tipoAPEP_SEQ");
		String numAPEP_SEQ = request.getParameter("numeroAPEP");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String data = request.getParameter("dataDocumento");
		String tipoDoc = request.getParameter("tipoDoc");
		String palavra1 = request.getParameter("chave1");
		String palavra2 = request.getParameter("chave2");
		String palavra3 = request.getParameter("chave3");
		String titulo = request.getParameter("titulo");
		
		BuscaDocEJB search = new BuscaDocEJB();
		List<DTO> docs = null;    
		
		try {
			
			docs = search.busca(identificacao, codigo, titulo, tipoAPEP_SEQ, numAPEP_SEQ, autor, destinatario, local, data, tipoDoc, palavra1, palavra2, palavra3); 

			for(DTO d : docs){
				
				DocumentoDTO doc = (DocumentoDTO) d;
				
				out.println("<tr>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTipoOrigem()+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getCodOrigem() +"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTitulo() 	+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getTipoId()		+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getCodId()		+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getAutor() 							+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getDestinatario()					+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getLocal()							+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getDataDocumento()					+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"+ doc.getTipoDocumento()					+"</label></td>");
				out.println("<td><label class=\"labelExibe\">"
						+ doc.getPalavrasChaves1() + " - " 
						+ doc.getPalavrasChaves2() + " - "
						+ doc.getPalavrasChaves3() + " - "
						+ "</label></td>");
				out.println("<td>"
						+ "<a href=\"#\"><img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\"/></a> "
						+ "<br>"
						+ "<a href=\"#\"><img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/></a> "
						+ "</td>");
				out.println("</tr>");
			}
		
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("document.location=('/GraoPara/public/index.jsp');");  
			out.write("</script>");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			out.println("<td colspan=\"3\">Nenhum d encontrado</td>");
		}
	}

}