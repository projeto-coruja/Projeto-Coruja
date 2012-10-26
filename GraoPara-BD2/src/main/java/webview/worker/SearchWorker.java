package webview.worker;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.TipoDocumento;
import webview.util.WebUtility;
import business.EJB.documents.DocumentEJB;
import business.EJB.documents.DocumentTypeEJB;
import business.EJB.user.AuthBean;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class SearchWorker {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void listAllDocuments(HttpServletRequest request, JspWriter out) throws IOException{
		
		//TODO: Pegar os valores via parâmetros.
		String tipoCodiceCaixa = request.getParameter("tipoCodCodiceCaixa");
		String tituloCodiceCaixa = request.getParameter("tituloCodiceCaixa");
		String codCodiceCaixaDe = request.getParameter("codDe");
		String codCodiceCaixaAte = request.getParameter("codAte");
		String anoInicioCodiceCaixa = request.getParameter("epocaDe");
		String anoFimCodiceCaixa = request.getParameter("epocaAte");
		
		String tipoCodDocumento = request.getParameter("tipoDaIdentificacao");
		String codDocumento = request.getParameter("numDaIdentificacao");
		
		String autor = request.getParameter("autor");
		String ocupacaoAutor = request.getParameter("autorOcupacao");
		
		String destinatario = request.getParameter("destinatario");
		String ocupacaoDestinatario = request.getParameter("destinatarioOcupacao");
		
		String tipoDocumento = request.getParameter("tipoDoc");
		String local = request.getParameter("local");
		String resumo = request.getParameter("resumo");
		
		String palavraChave1 = request.getParameter("chave1");
		String palavraChave2 = request.getParameter("chave2");
		String palavraChave3 = request.getParameter("chave3");
		
		String c_status = null;
		
		if(request.getCookies().length > 1){
			c_status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();
		}
		
		
		DocumentEJB search = new DocumentEJB();
		List<DTO> docs = null;    

		try {
			docs = search.findDocuments(tipoCodiceCaixa, 
					codCodiceCaixaDe, 
					codCodiceCaixaAte, 
					tituloCodiceCaixa, 
					anoInicioCodiceCaixa, 
					anoFimCodiceCaixa, 
					tipoCodDocumento, 
					codDocumento, 
					autor, ocupacaoAutor, 
					destinatario, 
					ocupacaoDestinatario, 
					tipoDocumento, 
					local, 
					resumo, 
					palavraChave1, 
					palavraChave2, 
					palavraChave3);

			for(DTO d : docs){
				
				Documento doc = (Documento) d;
				
				String codiceCaixa[] = doc.getCodiceCaixa().getCod().split("-");
				String codDoc[] = doc.getCod().split("-");
				String dataFormatted = sdf.format(doc.getData());
				String dataSplit[] = dataFormatted.split("/");
				
				out.println("<tr  class=\"trList\">");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ codiceCaixa[0]							+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ codiceCaixa[1]							+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getCodiceCaixa().getTitulo()		+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ codDoc[0]								+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ codDoc[1]								+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getTitulo()						+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getTipoDocumento().getNome()		+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getAutor().getNome() 				+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getAutor().getOcupacao() 			+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getDestinatario().getNome()		+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getDestinatario().getOcupacao()	+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getLocal()							+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ dataFormatted							+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"
						+ (doc.getPalavraChave1() != null ? doc.getPalavraChave1().getPalavra() + " - " : "" )
						+ (doc.getPalavraChave2() != null ? doc.getPalavraChave2().getPalavra() + " - " : "" )
						+ (doc.getPalavraChave3() != null ? doc.getPalavraChave3().getPalavra() : "" )
						+ "</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getResumo()						+"</label></td>");
				if(c_status != null && c_status.equals(AuthBean.LoginSuccessAdmin)){
					 out.println( "<td class=\"tdList\">"
								+ "<a href=\"/GraoPara/protected/admin/detalhesDocumentos.jsp?"
								+"codigo=" + doc.getCodiceCaixa().getCod()
								+"&codigoDoDocumento=" + doc.getCod()
								+"&titulo=" + doc.getTitulo()
								+"&dia=" + dataSplit[0]
								+"&mes=" + dataSplit[1]
								+"&ano=" + dataSplit[2]
								+"&autor=" + doc.getAutor()
								+"&destinatario=" + doc.getDestinatario()
								+"&local=" + doc.getLocal()
								+"&tipoDoc=" + doc.getTipoDocumento().getNome()
								+"&resumo=" + doc.getResumo()
								+"&chave1=" + (doc.getPalavraChave1() != null ? doc.getPalavraChave1().getPalavra() : "" )
								+"&chave2=" + (doc.getPalavraChave2() != null ? doc.getPalavraChave2().getPalavra() : "" )
								+"&chave3=" + (doc.getPalavraChave3() != null ? doc.getPalavraChave3().getPalavra() : "" )
								+ "\">"
								+ "<img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\"/></a> "
								+ "<br>"
								+ "<a href=\"/GraoPara/protected/admin/removeDoc?"
								+"&numeroAPEP=" + doc.getCod()
								+ "\">" 
								+ "<img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/></a></td> ");
				}
				out.println("</tr>");
			}
			
		} catch (UnreachableDataBaseException e) {
			out.write("<script>");  
			out.write("alert('Problemas ao acessar o banco de dados. Contate o suporte técnico e tente novamente mais tarde ');");  
			//out.write("window.location.replace('/GraoPara/public/index.jsp');");  
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
		DocumentTypeEJB ejb = new DocumentTypeEJB();
		
		try {
			lista = ejb.listAllTypeDocuments();
			
			for(DTO dto : lista){
				TipoDocumento tipoDoc = (TipoDocumento) dto;
				out.println("<tr  class=\"trList\">");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ tipoDoc.getNome()+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ tipoDoc.getDescricao()+"</label></td>");
				out.println("<td class=\"tdList\">"
						+ "<a href=\"/GraoPara/protected/admin/removeDocType?docType="+ tipoDoc.getNome() + "\">"
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
	
	
	public static void printDocumentInformation(HttpServletRequest request, JspWriter out) throws IOException{
		String tipo = request.getParameter("tipoCodigoDoDocumento");
		String num = request.getParameter("codigoDoDocumento");
		Documento doc = null;
		DocumentEJB busca = new DocumentEJB();
		
		String text;
		
		try {
			doc = busca.findSingleDocument(tipo, num);
			String data[] = doc.getData().toString().split("-");
			
			text = "<table >";
			
			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Código da caixa/códice</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getCodiceCaixa().getCod().replace("-", " - ")		+"</label></td>";
			text += "</tr>";
			
			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Título da caixa/códice</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getCodiceCaixa().getTitulo()		+"</label></td>";
			text += "</tr>";

			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Código do documento</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getCod() 							+"</label></td>";
			text += "</tr>";

			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Título do documento</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getTitulo()						+"</label></td>";
			text += "</tr>";

			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Autor</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getAutor().getNome()				+"</label></td>";
			text += "</tr>";

			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Ocupação do autor</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getAutor().getOcupacao()			+"</label></td>";
			text += "</tr>";
			
			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Destinatário</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getDestinatario().getNome()		+"</label></td>";
			text += "</tr>";

			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Ocupaçao do destinatário</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getDestinatario().getOcupacao()	+"</label></td>";
			text += "</tr>";
			
			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Local</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getLocal()							+"</label></td>";
			text += "</tr>";

			text += "<tr class=\"trList\">";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Data</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ data[2]+"/"+data[1]+"/"+data[0]		+"</label></td>";
			text += "</tr>";
			
			text += "<tr >";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Tipo de Documento</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getTipoDocumento().getNome()		+"</label></td>";
			text += "</tr>";
			
			text += "<tr >";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Palavras-Chave</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"	
					+ (doc.getPalavraChave1() != null ? text += doc.getPalavraChave1().getPalavra() + " - " : (text += " ") ) 
					+ (doc.getPalavraChave2() != null ? text += doc.getPalavraChave2().getPalavra() + " - " : (text += " ") )
					+ (doc.getPalavraChave3() != null ? text += doc.getPalavraChave3().getPalavra() : (text += "") )
					+ "</label></td>";
			text += "</tr>";
			
			text += "<tr >";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">Resumo</label></td>";
			text += "<td class=\"tdList\"><label class=\"labelExibe\">"+ doc.getResumo()	+"</label></td>";
			text += "</tr>";
			
			text += "</table>";

			out.println(text);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	
	public static String getAllAttributesAndValues(HttpServletRequest request, JspWriter out) throws IOException {
		
		String param = "";
		
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
		
		param += "identificacao="+identificacao;
		param += "&codigoDe="+codigoDe;
		param += "&codigoAte="+codigoAte;
		param += "&titulo="+titulo;
		param += "&numero="+numAPEP_SEQ;
		param += "&autor="+autor;
		param += "&destinatario="+destinatario;
		param += "&local="+local;
		param += "&anoIni="+anoIni;
		param += "&anoFim="+anoFim;
		param += "&tipoDoc="+tipoDoc;
		param += "&resumo="+resumo;
		param += "&chave1="+palavra1;
		param += "&chave2="+palavra2;
		param += "&chave3="+palavra3;
		
//		out.println(param);
		return param;
	}
}
