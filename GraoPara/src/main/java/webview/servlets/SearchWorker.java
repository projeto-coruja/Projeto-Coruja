package webview.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.dto.TipoDocumentoDTO;
import webview.WebUtility;
import business.EJB.docEJB.BuscaDocEJB;
import business.EJB.docEJB.TipoDocumentoEJB;
import business.EJB.userEJB.AuthBean;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class SearchWorker {
	
	public static void listAllDocuments(HttpServletRequest request, JspWriter out) throws IOException{
		String identificacao = request.getParameter("identificacao");
		String codigoDe = request.getParameter("codigoDe");
		String codigoAte = request.getParameter("codigoAte");
		String titulo = request.getParameter("titulo");
		String numAPEP_SEQ = request.getParameter("numero");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String anoIni = request.getParameter("anoIni");
		String anoFim = request.getParameter("anoFim");
		String tipoDoc = request.getParameter("tipoDoc");
		String resumo = request.getParameter("resumo");
		String palavra1 = request.getParameter("chave1");
		String palavra2 = request.getParameter("chave2");
		String palavra3 = request.getParameter("chave3");

		String c_status = null;
		
		if(request.getCookies().length > 1){
			c_status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();
		}
		
		
		BuscaDocEJB search = new BuscaDocEJB();
		List<DTO> docs = null;    

		try {
			docs = search.busca(identificacao.toUpperCase(), codigoDe, codigoAte, titulo, "", numAPEP_SEQ, autor, destinatario, local, anoIni, anoFim, tipoDoc, resumo, palavra1, palavra2, palavra3); 

			for(DTO d : docs){
				
				DocumentoDTO doc = (DocumentoDTO) d;
				
				String data[] = doc.getDataDocumento().toString().split("-");

				String palchave1 = "";
				String palchave2 = "";
				String palchave3 = "";
				if(doc.getPalavrasChaves1() != null) palchave1 = doc.getPalavrasChaves1().getPalavra();
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
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ data[2]+"/"+data[1]+"/"+data[0]		+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getTipoDocumento().getTipoDocumento()	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"
						+ palchave1 + " - " 
						+ palchave2 + " - "
						+ palchave3
						+ "</label></td>");
				if(c_status != null && c_status.equals(AuthBean.LoginSuccessAdmin)){
					 out.println( "<td class=\"tdList\">"
								+ "<a href=\"/GraoPara/protected/admin/detalhesDocumentosAdmin.jsp?"
								+"identificacao=" + doc.getOrigemDocumento().getTipoOrigem()
								+"&codigo=" + doc.getOrigemDocumento().getCodOrigem()
								+"&titulo=" + doc.getOrigemDocumento().getTitulo()
								+"&tipoAPEP_SEQ=" + doc.getIdNumDocumento().getTipoId()
								+"&numeroAPEP=" + doc.getIdNumDocumento().getCodId()
								+"&dia=" + data[2]
								+"&mes=" + data[1]
								+"&ano=" + data[0]
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
								+ "<a href=\"/GraoPara/protected/admin/removeDoc?"
								+"tipoAPEP_SEQ=" + doc.getIdNumDocumento().getTipoId()
								+"&numeroAPEP=" + doc.getIdNumDocumento().getCodId()
								+ "\">" 
								+ "<img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/></a></td> ");
				}
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listAllDocumentsTypes(HttpServletRequest request, JspWriter out) throws IOException{
		List<DTO> lista;
		TipoDocumentoEJB tipoEjb = new TipoDocumentoEJB();
		
		try {
			lista = tipoEjb.listAllTypeDocuments();
			
			for(DTO dto : lista){
				TipoDocumentoDTO tipoDoc = (TipoDocumentoDTO) dto;
				out.println("<tr  class=\"trList\">");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ tipoDoc.getTipoDocumento()+"</label></td>");
				out.println("<td class=\"tdList\">"
						+ "<a href=\"/GraoPara/protected/admin/removeDocType?docType="+ tipoDoc.getTipoDocumento() + "\">"
							+"<img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/>"
						+ "</a>"
					+ "</td> ");
				out.println("</tr>");
			}
			
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (DocumentTypeNotFoundException e) {
			out.println("<tr  class=\"trList\">");
			out.println("<td colspan=\"2\" class=\"tdList\"><label class=\"labelExibe\">Nenhum tipo de documento encontrado.</label></td>");
			out.println("</tr>");
		}
	}
}
