package webview.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.DTO;
import business.EJB.docEJB.BuscaDocEJB;
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
		
		String filePath = null;
		URL url = null;
		URLConnection connection = null;
		FileInputStream in = null;
		OutputStream out = null;
		

		BuscaDocEJB search = new BuscaDocEJB();
		try {
			List<DTO> resultSet = search.busca(identificacao.toUpperCase(), codigoDe, codigoAte, titulo, "", numAPEP_SEQ, autor, destinatario, local, anoIni, anoFim, tipoDoc, resumo, palavra1, palavra2, palavra3);
			if(resultSet == null)	throw new DocumentNotFoundException();
			filePath = SpreadsheetExport.generateSpreadsheet(resultSet);	
			url = new URL("ftp://"+filePath);
			connection = url.openConnection();
			
			response.setHeader("Content-Disposition", "attachment;filename=\""+ filePath +"\"");
			response.setContentLength((int)connection.getContentLength());
			response.setContentType("application/ods");
			File f = new File(filePath);
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
