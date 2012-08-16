package webview;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.docEJB.CadastroEJB;

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
		String tipoOrigem = request.getParameter("identificacao").toUpperCase();
		String codOrigem = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String tipoId = request.getParameter("tipo_num").toUpperCase();
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
		
		CadastroEJB CB = new CadastroEJB();
		CB.cadastrarDocumento(
				codOrigem, tipoOrigem, titulo, 
				tipoId, numId,
				tipoDoc,
				palChave1, palChave2, palChave3,
				autor, local, destinatario, resumo,
				dataDoc, email);
		//Provisório
		response.sendRedirect("/GraoPara/");
		
	}

}
