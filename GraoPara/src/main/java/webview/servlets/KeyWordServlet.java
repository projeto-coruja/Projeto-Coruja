package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.PalavraChaveDTO;

import business.EJB.docEJB.BuscaPalavraChaveEJB;
import business.EJB.docEJB.CadastroEJB;
import business.EJB.util.EJBUtility;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class KeyWordServlet
 */
@WebServlet("/doChangesToKeyWord")
public class KeyWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeyWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CadastroEJB cad = new CadastroEJB();
		String key = request.getParameter(EJBUtility.getHash("palavra", "SHA-256"));
		String action = request.getParameter(EJBUtility.getHash("action", "SHA-256"));
		String previous = request.getParameter("tab");
		
		try {
			if(action.equals(EJBUtility.getHash("approve", "SHA-256"))) cad.atualizarPalavraChave(key, key, true);
			else if(action.equals(EJBUtility.getHash("delete", "SHA-256")))	cad.deletarPalavraChave(key);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("/GraoPara/protected/admin/painelAdmin.jsp#tab"+previous);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CadastroEJB cad = new CadastroEJB();
		BuscaPalavraChaveEJB bpcEJB = new BuscaPalavraChaveEJB();
		String keyFromParameter = request.getParameter("palavra");
		String oldKeyName = request.getParameter("palavraAntiga");
		String newKeyName = request.getParameter("palavraNova");
	    PrintWriter out = response.getWriter();   
		response.setContentType("text/html");  
	    
		PalavraChaveDTO key;
	
		try {
			key = bpcEJB.buscarPalavraChave(oldKeyName);
			cad.atualizarPalavraChave(oldKeyName, newKeyName, key.isAprovada());
			
		    out.println("<script>");  
		    out.println("alert('Palavra-chave atualizado com sucesso.');");  
		    out.println("document.location=('/GraoPara/protected/admin/painelAdmin.jsp');");
		    out.println("</script>");
			
		} catch (UnreachableDataBaseException e) {
		    out.println("<script>");  
		    out.println("alert('Não foi possível conectar com o banco de dados.');");  
		    out.println("document.location=('/GraoPara/public/index.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
		    out.println("<script>");  
		    
		    if(e.getMessage().equals("Palavra chave nova já existente"))	out.println("alert('A palavra chave já existe.');");
		    else	out.println("alert('Por favor preencher todos os campos.');");
		    
		    if(keyFromParameter != null)	out.println("document.location=('/GraoPara/protected/admin/editarPalavraChave.jsp?palavra="+ keyFromParameter +"');");
		    else if(oldKeyName != null)	out.println("document.location=('/GraoPara/protected/admin/editarPalavraChave.jsp?palavra="+ oldKeyName +"');");
		    else	out.println("document.location=('/GraoPara/protected/admin/editarPalavraChave.jsp');");
		    
		    out.println("</script>");
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
		    out.println("<script>");  
		    out.println("alert('Palavra-chave não encontrada.');");  
		    out.println("document.location=('/GraoPara/protected/admin/editarPalavraChave.jsp?palavra=');");
		    out.println("</script>");
			e.printStackTrace();
		}
	}

}
