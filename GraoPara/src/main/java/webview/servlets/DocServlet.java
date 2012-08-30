package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.DocumentoDTO;

import webview.WebUtility;

import business.EJB.docEJB.BuscaDocEJB;
import business.EJB.docEJB.CadastroEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

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
		String dataDia = request.getParameter("dia");
		String dataMes = request.getParameter("mes");
		String dataAno = request.getParameter("ano");
		String tipoDoc = request.getParameter("tipoDoc");
		String resumo = request.getParameter("resumo");
		String palChave1 = request.getParameter("chave1");
		String palChave2 = request.getParameter("chave2");
		String palChave3 = request.getParameter("chave3");
		
		String action = request.getParameter("action");
		
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		
		GregorianCalendar dataDoc = new GregorianCalendar(Integer.parseInt(dataAno), Integer.parseInt(dataMes), Integer.parseInt(dataDia));
		
		CadastroEJB CB = new CadastroEJB();
		if(action.equals("add")){
			try {
				CB.cadastrarDocumento(
						codOrigem, tipoOrigem, titulo, 
						tipoId, numId,
						tipoDoc,
						palChave1, palChave2, palChave3,
						autor, local, destinatario, resumo,
						dataDoc, email);
				out.println("<script>");  
			    out.println("alert('Documento cadastrado com sucesso!')");  
			    out.println("history.go(-1);");  
			    out.println("</script>");
			} catch (UnreachableDataBaseException e) {
				out.println("<script>");  
			    out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde." + e.getStackTrace() + "');");  
			    out.println("document.location=('/GraoPara/protected/user/indexUser.jsp');");  
			    out.println("</script>");
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				System.err.println("Erro ao indentificar um usuário no cadastro de documento!");
				e.printStackTrace();
			}
		}

		if(action.equals("update")){
			try {
				CB.atualizarDocumento(codOrigem, tipoOrigem, titulo, 
						tipoId, numId,
						tipoDoc,
						palChave1, palChave2, palChave3,
						autor, local, destinatario, resumo,
						dataDoc, email);
				out.println("<script>");  
			    out.println("alert('Documento Atualizado com sucesso!');");  
			    out.println("document.location=('/GraoPara/public/index.jsp');");  
			    out.println("</script>");
			} catch (UnreachableDataBaseException e) {
				out.println("<script>");  
			    out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde." + e.getStackTrace() + "');");  
			    out.println("history.go(-1)");  
			    out.println("</script>");
				e.printStackTrace();
			} catch (DocumentNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoAPEP_SEQ = request.getParameter("tipoAPEP_SEQ");
		String numAPEP_SEQ = request.getParameter("numeroAPEP");
		
		BuscaDocEJB search = new BuscaDocEJB();
		try {
			DocumentoDTO docs = search.busca(tipoAPEP_SEQ, numAPEP_SEQ);
			CadastroEJB delete = new CadastroEJB();
			delete.deletarDocumento(docs);
		} catch (UnreachableDataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
