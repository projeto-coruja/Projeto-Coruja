package webview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.CadastroBean;
import business.exceptions.DuplicateUserException;
import business.exceptions.IncorrectLoginInformationException;
import business.exceptions.UnreachableDataBaseException;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(!senha.equals(request.getParameter("confsenha")))
			response.sendRedirect("NOPE.jsp");
		else
		{
			CadastroBean cf = new CadastroBean();
			try {
				cf.adicionarUsuario(email, nome, senha);
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
			    out.println("<script>");  
			    out.println("alert('Usuário adicionado! Aguarde a aprovação dos seus direitos de edição.');");  
			    out.println("document.location=('/GraoPara/');");  
			    out.println("</script>");
			} catch (UnreachableDataBaseException e) {
				e.printStackTrace();
			} catch (IncorrectLoginInformationException e) {
//				response.sendRedirect(request.getContextPath() + "/pages/public/Error.jsp");
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
				out.println("<script>");  
			    out.println("alert('Email inválido! Por favor acesse a área de cadastro e tente novamente.');");  
			    out.println("document.location=('/GraoPara/');");  
			    out.println("</script>");
			} catch (DuplicateUserException e) {
				response.setContentType("text/html");  
			    PrintWriter out=response.getWriter();   
				out.println("<script>");  
			    out.println("alert('Email já em uso! Por favor acesse a área de cadastro e tente novamente.');");  
			    out.println("document.location=('/GraoPara/');");  
			    out.println("</script>");
			}
		}

	}

}
