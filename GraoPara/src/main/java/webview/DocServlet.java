package webview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.TipoDocumentoDTO;

import business.DAO.documents.DocumentDAO;
import business.DAO.login.LoginDAO;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class DocServlet
 */
@WebServlet("/addDoc")
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoOrigem = request.getParameter("identificacao");
		String codOrigem = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String tipoId = request.getParameter("tipo_num");
		String numId = request.getParameter("numero");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String data = request.getParameter("data");
		String tipoDoc = request.getParameter("tipoDoc");
		String resumo = request.getParameter("resumo");
		String palChave1 = request.getParameter("chave1");
		String palChave2 = request.getParameter("chave2");
		String palChave3 = request.getParameter("chave3");
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		
		//Fazendo parse da data
		String[] data_split = data.split("/");
		int[] data_parse = new int[3];
		for(int i = 0; i < 3; i++)
			data_parse[i] = Integer.parseInt(data_split[i]);
		GregorianCalendar dataDoc = new GregorianCalendar(
				data_parse[2], data_parse[1], data_parse[0]);
		
		PalavraChaveDTO chave_ver1 = null, chave_ver2 = null, chave_ver3 = null;
		
		//Fazendo verificação das palavras chaves
		if(!palChave1.isEmpty())
			chave_ver1 = new PalavraChaveDTO(palChave1, false); 
		if(!palChave1.isEmpty())
			chave_ver2 = new PalavraChaveDTO(palChave2, false); 
		if(!palChave1.isEmpty())
			chave_ver3 = new PalavraChaveDTO(palChave3, false);
		
		DocumentDAO dd = new DocumentDAO();
		LoginDAO ld = new LoginDAO();
		try {
			dd.addDocument(new DocumentoDTO(
					null, 
					new OrigemDTO(codOrigem, tipoOrigem, titulo), 
					new IdNumDocumentoDTO(tipoId, numId), 
					new TipoDocumentoDTO(tipoDoc), 
					autor, local, destinatario, resumo, 
					dataDoc, 
					new Date(), 
					ld.findUserByEmail(email), 
					chave_ver1, chave_ver2, chave_ver3));
		} catch (UnreachableDataBaseException e) {
			response.setContentType("text/html");  
		    PrintWriter out=response.getWriter();   
		    out.println("<script>");  
		    out.println("alert('Erro no banco de dados. Contate o suporte e tente novamente mais tarde.');");  
		    out.println("document.location=('/GraoPara/');");  
		    out.println("</script>");
			e.printStackTrace();
		}
		
	}

}
