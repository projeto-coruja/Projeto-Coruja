package webview.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import business.EJB.docEJB.BuscaDocEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class SearchWorker {
	
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
