package webview.servlet;

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

import persistence.dto.DTO;
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
		String tipoCodigoCaixa = request.getParameter("");
		String codigoDe = request.getParameter("codigoDe");
		String codigoAte = request.getParameter("codigoAte");
		String titulo = request.getParameter("titulo");
		String tipoAPEP_SEQ = request.getParameter("");
		String numAPEP_SEQ = request.getParameter("numero");
		String autor = request.getParameter("autor");
		String ocupacaoAutor = null;
		String destinatario = request.getParameter("destinatario");
		String ocupacaoDestinatario = null;
		String local = request.getParameter("local");
		String anoIni = request.getParameter("anoIni");
		String anoFim = request.getParameter("anoFim");
		String tipoDoc = request.getParameter("tipoDoc");
		String resumo = request.getParameter("resumo");
		String palavraChave1 = request.getParameter("chave1");
		String palavraChave2 = request.getParameter("chave2");
		String palavraChave3 = request.getParameter("chave3");
		
		String filePath = null;
		FileInputStream in = null;
		OutputStream out = null;
		

		DocumentEJB search = new DocumentEJB();
		try {
			List<DTO> resultSet = search.findDocuments(tipoCodigoCaixa, 
					codigoDe, 
					codigoAte, 
					titulo, 
					anoIni, 
					anoFim, 
					tipoAPEP_SEQ, 
					numAPEP_SEQ, 
					autor, 
					ocupacaoAutor, 
					destinatario, 
					ocupacaoDestinatario, 
					tipoDoc, 
					local, 
					resumo, 
					palavraChave1, 
					palavraChave2, 
					palavraChave3);
			
			if(resultSet == null)	throw new DocumentNotFoundException();
			filePath = SpreadsheetExport.generateSpreadsheet(resultSet);	
			File f = new File(filePath);
			response.setHeader("Content-Disposition", "attachment;filename=\""+ filePath +"\"");
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
