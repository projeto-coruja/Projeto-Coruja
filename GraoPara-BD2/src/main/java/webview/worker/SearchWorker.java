package webview.worker;

import static webview.util.WebUtility.isInit;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import datatype.SimpleDate;

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
	
	private static String minData = "1000/01/01";
	private static String maxData = "3000/01/01";
	
	public static String getMinData(){
		return minData;
	}
		
	public static void listAllDocuments(HttpServletRequest request, JspWriter out) throws IOException{
		
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
			try{
				c_status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();
			} catch(NullPointerException e){
				c_status = null;
			}
		}
		
		String anoIni = request.getParameter("anoIni");
		String anoFim = request.getParameter("anoFim");
		String dataIni = null, dataFim = null;;
		SimpleDate dataDocIni = null, dataDocFim = null;
		
		if(isInit(anoIni)) {
			dataIni = anoIni;
		} else {
			dataIni = minData;
		}
		if(isInit(anoFim)) {
			dataFim = anoFim + "/12/31";
		} else {
			dataFim = maxData;
		}
		
		dataDocIni = SimpleDate.parse(dataIni);
		dataDocFim = SimpleDate.parse(dataFim);
		
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
					dataDocIni, dataDocFim, autor, ocupacaoAutor, 
					destinatario, 
					ocupacaoDestinatario, 
					tipoDocumento, 
					local, 
					resumo, 
					palavraChave1, 
					palavraChave2, 
					palavraChave3);
			

			String lastCodex = "";
			for(DTO d : docs){
				
				Documento doc = (Documento) d;
				
				String codDoc[] = doc.getCod().split("-");
				if(!lastCodex.equals(doc.getCodiceCaixa().getCod())){
					if(!lastCodex.equals("")){
						out.println("</table>");
						out.println("<br />");
					}
					out.println("<h1 class=\"resultLabel\">" + doc.getCodiceCaixa().getCod().replace("-", " - ") + ": " + doc.getCodiceCaixa().getTitulo() + " ( " + doc.getCodiceCaixa().getAnoInicio() + " - " + doc.getCodiceCaixa().getAnoFim() + ")</h1>");
					out.println("<br />");
					out.println("<table class=\"tableList\">");
				}
				else{
					out.println("<tr class=\"trList\">");
					out.println("<td class=\"tdList\" colspan=\"4\"><br /></td>");
					out.println("</tr>");
				}
				out.println("<tr class=\"trList\">");
				out.println("<td class=\"tdList\" rowspan=\"5\"><label class=\"labelExibe\">"+ codDoc[0] + "<br />" +  codDoc[1] + "</label></td>");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + doc.getTipoDocumento().getNome() + "</label></td>");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + doc.getLocal() + "</label></td>");
				out.println("<td class=\"tdList\" rowspan=\"5\"><label class=\"labelExibe\">"+ 
						(doc.getUrl() != null && !doc.getUrl().equals("") ? "<a href=\"" + doc.getUrl() + "\">URL</a>" : "" ));
				if(c_status != null && c_status.equals(AuthBean.LoginSuccessAdmin)){
					out.println( "<a href=\"/GraoPara/protected/admin/editarDocumentos.jsp?"
					+"codigoDoDocumento=" + doc.getCod()
					+ "\">"
					+ "<img src=\"/GraoPara/images/edit.png\" title=\"Editar\" alt=\"Editar\"/></a> "
					+ "<br>"
					+ "<a href=\"/GraoPara/protected/admin/removeDoc?"
					+"numeroAPEP=" + doc.getCod()
					+ "\">"
					+ "<img src=\"/GraoPara/images/remove.png\" title=\"Remover\" alt=\"Remover\"/></a></td> ");
				}
				out.println("</label></td>");
				out.println("</tr>");
				out.println("<tr class=\"trList\">");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + doc.getAutor().getNome() + "</label></td>");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + doc.getAutor().getOcupacao() + "</label></td>");
				out.println("</tr>");
				out.println("<tr class=\"trList\">");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + doc.getDestinatario().getNome() + "</label></td>");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + doc.getDestinatario().getOcupacao() + "</label></td>");
				out.println("</tr>");
				out.println("<tr class=\"trList\">");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + (doc.getData() != null ? doc.getData().format() : "Sem data.") + "</label></td>");
				out.println("<td class=\"tdList\" ><label class=\"labelExibe\">" + 
						(doc.getPalavraChave1() != null ? doc.getPalavraChave1().getPalavra() : "") +
						(doc.getPalavraChave2() != null ? (doc.getPalavraChave1() != null ? " - " : "") + doc.getPalavraChave2().getPalavra() + "  " : "") +
						(doc.getPalavraChave3() != null ? (doc.getPalavraChave1() != null || doc.getPalavraChave2() != null ? " - " : "") + doc.getPalavraChave3().getPalavra() + "  " : "") +
						"</label></td>");
				out.println("</tr>");
				out.println("<tr class=\"trList\">");
				out.println("<td class=\"tdList\" colspan=\"2\"><label class=\"labelExibe\">" + doc.getResumo() + "</label></td>");
				out.println("</tr>");
				
				lastCodex = doc.getCodiceCaixa().getCod();
			}
			out.println("</table>");
			
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
	
	public static void listAllDocumentsTypesForUser(HttpServletRequest request, JspWriter out) throws IOException{
		List<DTO> lista;
		DocumentTypeEJB ejb = new DocumentTypeEJB();

		try {
			lista = ejb.listAllTypeDocuments();
			
			for(DTO dto : lista){
				TipoDocumento tipoDoc = (TipoDocumento) dto;
				out.println("<tr  class=\"trList\">");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ tipoDoc.getNome()+"</label></td>");
				out.println("<td class=\"tdList\"><label class=\"labelExibe\">"+ tipoDoc.getDescricao()+"</label></td>");
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
	
	public static void getInfoFromDocument(HttpServletRequest request){
		String code = request.getParameter("codigoDoDocumento");
		DocumentEJB docEJB = new DocumentEJB();
		try {
			Documento doc = docEJB.findSingleDocument(code);
			String dataFormatted;
			if(doc.getData() == null) dataFormatted = "Ilegível/Sem Data";	
			else
				dataFormatted = doc.getData().format();
			
			request.setAttribute("codigo", doc.getCodiceCaixa().getCod());
			request.setAttribute("codCodiceCaixa", doc.getCodiceCaixa().getCod().replace("-", " - ") + ": " + doc.getCodiceCaixa().getTitulo() + " (" + doc.getCodiceCaixa().getAnoInicio() + " - " + doc.getCodiceCaixa().getAnoFim() + ")");
			request.setAttribute("codDocumento",doc.getCod().replace("-", " - "));
			request.setAttribute("autorNome",doc.getAutor().getNome());
			request.setAttribute("autorOcupacao",doc.getAutor().getOcupacao()); 
			request.setAttribute("destinatarioNome",doc.getDestinatario().getNome());
			request.setAttribute("destinatarioOcupacao",doc.getDestinatario().getOcupacao()); 
			request.setAttribute("local",doc.getLocal());
			request.setAttribute("data",dataFormatted); 
			request.setAttribute("url",doc.getUrl());
			request.setAttribute("resumo",doc.getResumo());
			request.setAttribute("tipoDocumento",doc.getTipoDocumento().getNome() + " - " + doc.getTipoDocumento().getDescricao()); 
			request.setAttribute("palavraChave1",(doc.getPalavraChave1() != null ? doc.getPalavraChave1().getPalavra() : ""));
			request.setAttribute("palavraChave2",(doc.getPalavraChave2() != null ? doc.getPalavraChave2().getPalavra() : ""));
			request.setAttribute("palavraChave3",(doc.getPalavraChave3() != null ? doc.getPalavraChave3().getPalavra() : ""));
																		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		}	
	}
	
	public static void getRawInfoFromDocument(HttpServletRequest request){
		String code = request.getParameter("codigoDoDocumento");
		DocumentEJB docEJB = new DocumentEJB();
		try {
			Documento doc = docEJB.findSingleDocument(code);
			String[] cdCxSplit = doc.getCodiceCaixa().getCod().split("-");
			String[] codDocSplit = doc.getCod().split("-");
			SimpleDate sd = doc.getData();
			String ano = null, mes = null, dia = null;
			if(sd != null) {
				ano = String.valueOf(sd.getYear());
				try {
					mes = String.valueOf(sd.getMonth());
				} catch (IllegalAccessError e) {
					//Do nothing
				}
				try {
					dia = String.valueOf(sd.getDay());
				} catch (IllegalAccessError e) {
					//Do nothing
				}
			}
		
			request.setAttribute("codigo", doc.getCodiceCaixa().getCod());
			request.setAttribute("codCodiceCaixa", cdCxSplit[0]);
			request.setAttribute("tipoCodiceCaixa", cdCxSplit[1]);
			request.setAttribute("codDocumento", codDocSplit[1]);
			request.setAttribute("tipoCodDocumento", codDocSplit[0]);
			request.setAttribute("autorNome",doc.getAutor().getNome());
			request.setAttribute("autorOcupacao",doc.getAutor().getOcupacao()); 
			request.setAttribute("destinatarioNome",doc.getDestinatario().getNome());
			request.setAttribute("destinatarioOcupacao",doc.getDestinatario().getOcupacao()); 
			request.setAttribute("local",doc.getLocal());
			request.setAttribute("ano", ano); 
			request.setAttribute("mes", mes); 
			request.setAttribute("dia", dia); 
			request.setAttribute("url",doc.getUrl());
			request.setAttribute("resumo",doc.getResumo());
			request.setAttribute("tipoDoc",doc.getTipoDocumento().getNome()); 
			request.setAttribute("palavraChave1",(doc.getPalavraChave1() != null ? doc.getPalavraChave1().getPalavra() : ""));
			request.setAttribute("palavraChave2",(doc.getPalavraChave2() != null ? doc.getPalavraChave2().getPalavra() : ""));
			request.setAttribute("palavraChave3",(doc.getPalavraChave3() != null ? doc.getPalavraChave3().getPalavra() : ""));
																		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		} catch (UnreachableDataBaseException e) {
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
