package webview.servlet;

import static webview.util.WebUtility.isInit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatype.SimpleDate;

import persistence.dto.DTO;
import webview.worker.SearchWorker;
import business.EJB.documents.DocumentEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.export.SpreadsheetExport;

/**
 * Servlet implementation class Download
 */
@WebServlet("/doDownload")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		String anoIni = request.getParameter("anoIni");
		String anoFim = request.getParameter("anoFim");
		String dataIni = null, dataFim = null;;
		SimpleDate dataDocIni = null, dataDocFim = null;
		
		if(isInit(anoIni)) {
			dataIni = anoIni;
		} else {
			dataIni = SearchWorker.getMinData();
		}
		if(isInit(anoFim)) {
			dataFim = anoFim + "/12/31";
		} else {
			dataFim = SearchWorker.getMaxData();
		}
		
		dataDocIni = SimpleDate.parse(dataIni);
		dataDocFim = SimpleDate.parse(dataFim);

		DocumentEJB search = new DocumentEJB();
		
		String filePath = null;
		FileInputStream in = null;
		OutputStream out = null;
		try {
			List<DTO> resultSet = search.findDocuments(tipoCodiceCaixa, 
					codCodiceCaixaDe, 
					codCodiceCaixaAte, 
					tituloCodiceCaixa, 
					anoInicioCodiceCaixa, 
					anoFimCodiceCaixa, 
					tipoCodDocumento, 
					codDocumento, 
					dataDocIni, dataDocFim, 
					autor, 
					ocupacaoAutor, 
					destinatario, 
					ocupacaoDestinatario, 
					tipoDocumento, 
					local, 
					resumo, 
					palavraChave1, 
					palavraChave2, 
					palavraChave3);
			
			
			if(resultSet == null)	throw new DocumentNotFoundException();
			filePath = SpreadsheetExport.generateSpreadsheet(resultSet);	

			File f = new File(filePath);
			f.canWrite();
			response.setHeader("Content-Disposition", "attachment;filename=\""+ filePath.split("/")[2] +"\"");
			response.setContentLength((int) f.length());
			response.setContentType("application/ods");
			in = new FileInputStream(f);
			out = response.getOutputStream();

			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = in.read(bytes)) != -1){
				out.write(bytes,0,read);
			}
			
			in.close();
			out.flush();
			out.close();
			
		} catch (IOException e){
			e.printStackTrace();
		} catch (DocumentNotFoundException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
