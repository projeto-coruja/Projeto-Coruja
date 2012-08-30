package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EJB.userEJB.AdminBean;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Servlet implementation class AccountApprovalServlet
 */
@WebServlet("/protected/admin/approveAccount")
public class AccountApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminBean ab = new AdminBean();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			ab.alterarPermissoesUsuario(request.getParameter("email"), "user");
			response.sendRedirect(request.getContextPath() + "/protected/admin/painelAdmin.jsp#tab2");
		} catch (IncorrectProfileInformationException e) {
			out.println("<script>");  
		    out.println("alert('Erro de profile inválido, contate o suporte.');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (UnreachableDataBaseException e) {
			out.println("<script>");  
		    out.println("alert('Erro de banco de dados, contate o suporte.');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			out.println("<script>");  
		    out.println("alert('Erro de usuário inválido, contate o suporte.');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		} catch (ProfileNotFoundException e) {
			out.println("<script>");  
		    out.println("alert('Erro de profile não encontrado, contate o suporte.');");  
		    out.println("document.location=('/GraoPara/protected/admin/indexAdmin.jsp');");  
		    out.println("</script>");
			e.printStackTrace();
		}
	}

}
