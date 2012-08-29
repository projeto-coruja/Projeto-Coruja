package webview.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		String titulo = request.getParameter("titulo");
		String tipoAPEP_SEQ = request.getParameter("tipoAPEP_SEQ");
		String numAPEP_SEQ = request.getParameter("numeroAPEP");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String dia = request.getParameter("dia");
		String mes = request.getParameter("mes");
		String ano = request.getParameter("ano");
		String tipoDoc = request.getParameter("tipoDoc");
		String palavra1 = request.getParameter("chave1");
		String palavra2 = request.getParameter("chave2");
		String palavra3 = request.getParameter("chave3");
		
		String data_concat = ano.concat(mes.concat(dia));
		
		BuscaDocEJB search = new BuscaDocEJB();
		List<DTO> docs = null;    
		
		try {
			docs = search.busca(identificacao, codigo, titulo, tipoAPEP_SEQ, numAPEP_SEQ, autor, destinatario, local, data_concat, tipoDoc, palavra1, palavra2, palavra3); 

			for(DTO d : docs){
				
				DocumentoDTO doc = (DocumentoDTO) d;
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = doc.getDataDocumento();
				int c_dia = c.get(Calendar.DAY_OF_MONTH);
				int c_mes = c.get(Calendar.MONTH) + 1;
				int c_ano = c.get(Calendar.YEAR);
				String palchave1 = doc.getPalavrasChaves1().getPalavra();
				String palchave2 = "";
				String palchave3 = "";
				if(doc.getPalavrasChaves2() != null) palchave2 = doc.getPalavrasChaves2().getPalavra();
				if(doc.getPalavrasChaves3() != null) palchave3 = doc.getPalavrasChaves3().getPalavra();
				
				out.println("<tr  class=\"trList\">");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTipoOrigem()+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getCodOrigem() +"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTitulo() 	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getTipoId()	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getCodId()		+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getAutor() 						+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getDestinatario()					+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getLocal()							+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ s.format(c.getTime())					+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getTipoDocumento().getTipoDocumento()	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"
						+ palchave1 + " - " 
						+ palchave2 + " - "
						+ palchave3 + " - "
						+ "</label></td>");
				out.println("<td class=\"tdList\">"
						+ "<a href=\"/GraoPara/protected/admin/detalhesDocumentosAdmin.jsp?"
							+"identificacao=" + doc.getOrigemDocumento().getTipoOrigem()
							+"&codigo=" + doc.getOrigemDocumento().getCodOrigem()
							+"&titulo=" + doc.getOrigemDocumento().getTitulo()
							+"&tipoAPEP_SEQ=" + doc.getIdNumDocumento().getTipoId()
							+"&numeroAPEP=" + doc.getIdNumDocumento().getCodId()
							+"&dia=" + String.valueOf(c_dia)
							+"&mes=" + String.valueOf(c_mes)
							+"&ano=" + String.valueOf(c_ano)
							+"&autor=" + doc.getAutor()
							+"&destinatario=" + doc.getDestinatario()
							+"&local=" + doc.getLocal()
							+"&tipoDoc=" + doc.getTipoDocumento().getTipoDocumento()
							+"&resumo=" + doc.getResumo()
							+"&chave1=" + palchave1
							+"&chave2=" + palchave2
							+"&chave3=" + palchave3
							+ "\">"
							+ "<img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\"/></a> "
						+ "<br>"
						+ "<a href=\"/GraoPara/addDoc?"
							+"tipoAPEP_SEQ=" + doc.getIdNumDocumento().getTipoId()
							+"&numeroAPEP=" + doc.getIdNumDocumento().getCodId()
							+ "\">"
							+ "<img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/></a> "
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
			out.write("<script>");  
			out.write("alert('Nenhum documento encontrado!');");  
			out.write("history.go(-1)");  
			out.write("</script>");
		}
	}
	
	public static void listAllDocumentsByYear(HttpServletRequest request, JspWriter out) throws IOException{
		String data = request.getParameter("dataDocumento");
		
		BuscaDocEJB search = new BuscaDocEJB();
		List<DTO> docs = null;    
		
		try {
			docs = search.searchByYear(data); 

			for(DTO d : docs){

				DocumentoDTO doc = (DocumentoDTO) d;
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = doc.getDataDocumento();
				int c_dia = c.get(Calendar.DAY_OF_MONTH);
				int c_mes = c.get(Calendar.MONTH) + 1;
				int c_ano = c.get(Calendar.YEAR);

				String palchave1 = doc.getPalavrasChaves1().getPalavra();
				String palchave2 = "";
				String palchave3 = "";
				if(doc.getPalavrasChaves2() != null) palchave2 = doc.getPalavrasChaves2().getPalavra();
				if(doc.getPalavrasChaves3() != null) palchave3 = doc.getPalavrasChaves3().getPalavra();

				out.println("<tr  class=\"trList\">");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTipoOrigem()+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getCodOrigem() +"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getOrigemDocumento().getTitulo() 	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getTipoId()	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getIdNumDocumento().getCodId()		+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getAutor() 						+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getDestinatario()					+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getLocal()							+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ s.format(c.getTime())					+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getTipoDocumento().getTipoDocumento()	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"
						+ palchave1 + " - " 
						+ palchave2 + " - "
						+ palchave3 + " - "
						+ "</label></td>");
				out.println("<td class=\"tdList\">"
						+ "<a href=\"/GraoPara/protected/admin/detalhesDocumentosAdmin.jsp?"
						+"identificacao=" + doc.getOrigemDocumento().getTipoOrigem()
						+"&codigo=" + doc.getOrigemDocumento().getCodOrigem()
						+"&titulo=" + doc.getOrigemDocumento().getTitulo()
						+"&tipoAPEP_SEQ=" + doc.getIdNumDocumento().getTipoId()
						+"&numeroAPEP=" + doc.getIdNumDocumento().getCodId()
						+"&dia=" + String.valueOf(c_dia)
						+"&mes=" + String.valueOf(c_mes)
						+"&ano=" + String.valueOf(c_ano)
						+"&autor=" + doc.getAutor()
						+"&destinatario=" + doc.getDestinatario()
						+"&local=" + doc.getLocal()
						+"&tipoDoc=" + doc.getTipoDocumento().getTipoDocumento()
						+"&resumo=" + doc.getResumo()
						+"&chave1=" + palchave1
						+"&chave2=" + palchave2
						+"&chave3=" + palchave3
						+ "\">"
						+ "<img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\"/></a> "
						+ "<br>"
						+ "<a href=\"/GraoPara/addDoc?"
						+"tipoAPEP_SEQ=" + doc.getIdNumDocumento().getTipoId()
						+"&numeroAPEP=" + doc.getIdNumDocumento().getCodId()
						+ "\">"
						+ "<img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/></a> "
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
			out.write("<script>");  
			out.write("alert('Nenhum documento encontrado!');");  
			out.write("history.go(-1)");  
			out.write("</script>");
		}
	}
}
