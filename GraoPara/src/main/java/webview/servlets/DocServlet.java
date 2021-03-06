package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import webview.WebUtility;

import business.EJB.docEJB.CadastroEJB;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Servlet implementation class DocServlet
 */
@WebServlet(urlPatterns={"/protected/user/addDoc", "/protected/admin/addDoc"})
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] identificacao = request.getParameter("identificacao").split("-");
//		String codOrigem = request.getParameter("codigo");
		
		String tipoOrigem = identificacao[0];
		String codOrigem = identificacao[1];
		String titulo = identificacao[2];
		String tipoId = request.getParameter("tipo_num").toUpperCase();
		String numId = request.getParameter("numero");
		String autor = request.getParameter("autor");
		String destinatario = request.getParameter("destinatario");
		String local = request.getParameter("local");
		String dataDia = request.getParameter("dia");
		String dataMes = request.getParameter("mes");
		String dataAno = request.getParameter("ano");
		String tipoDoc = request.getParameter("tipoDoc");
		String resumo = request.getParameter("resumo");
		String palChave1 = request.getParameter("chave1");
		String palChave2 = request.getParameter("chave2");
		String palChave3 = request.getParameter("chave3");
						
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		
//		GregorianCalendar dataDoc = new GregorianCalendar(Integer.parseInt(dataAno), Integer.parseInt(dataMes), Integer.parseInt(dataDia));
		Date dataDoc = null;
		try {
			String dataTmp = dataAno+"-"+dataMes+"-"+dataDia;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			dataDoc = (Date) df.parse(dataTmp);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		CadastroEJB CB = new CadastroEJB();
		try {
			CB.cadastrarDocumento(codOrigem, tipoOrigem, titulo, tipoId, numId,tipoDoc,palChave1, palChave2, palChave3, autor, local, destinatario, resumo, dataDoc, email);
			response.setContentType("text/html");  
		    PrintWriter out=response.getWriter();   
		    out.println("<script>");  
		    out.println("alert('Documento adicionado com sucesso!');");  
		    out.println("history.go(-1);");  
		    out.println("</script>");
		} catch (UnreachableDataBaseException e) {
			response.setContentType("text/html");  
		    PrintWriter out=response.getWriter();   
			out.println("<script>");  
			out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde." + e.getStackTrace() + "');");  
			out.println("document.location=('/GraoPara/protected/user/indexUser.jsp');");  
			out.println("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			System.err.println("Erro ao indentificar um usuário no cadastro de documento!");
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			response.setContentType("text/html");  
		    PrintWriter out=response.getWriter();   
		    out.println("<script>");  
		    out.println("alert('Problema ao cadastrar documento, Já existe documento com a identificação fornecido!');");  
		    out.println("history.go(-1);");  
		    out.println("</script>");
		}
	}

}
