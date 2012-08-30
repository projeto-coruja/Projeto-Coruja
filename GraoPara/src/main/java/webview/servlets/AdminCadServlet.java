package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.WebUtility;
import business.EJB.userEJB.AdminBean;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;
import business.exceptions.login.UnreachableDataBaseException;

/**
 * Servlet implementation class AdminCadServlet
 */
@WebServlet("/protected/admin/doAdminRegister")
public class AdminCadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = WebUtility.removeAccents(request.getParameter("nome"));
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String permissao = request.getParameter("permissao");

		if (!senha.equals(request.getParameter("confsenha"))) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Senha inválida! Tente novamente.');");
			out.println("document.location=('/GraoPara/protected/admin/cadUserAdmin.jsp');");
			out.println("</script>");
		} else {
			AdminBean ab = new AdminBean();
			try {
				ab.adicionarUsuario(email, nome, senha, permissao);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Usuário adicionado!');");
				out.println("document.location=('/GraoPara/protected/admin/cadUserAdmin.jsp');");
				out.println("</script>");
			} catch (UnreachableDataBaseException e) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Erro no banco de dados! Contate o suporte e tente novamente mais tarde. ');");
				out.println("document.location=('/GraoPara/protected/admin/cadUserAdmin.jsp');");
				out.println("</script>");
				e.printStackTrace();
			} catch (IncorrectLoginInformationException e) {
				// response.sendRedirect(request.getContextPath() +
				// "/pages/public/Error.jsp");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Email inválido!');");
				out.println("document.location=('/GraoPara/protected/admin/cadUserAdmin.jsp');");
				out.println("</script>");
			} catch (DuplicateUserException e) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Email já em uso!');");
				out.println("document.location=('/GraoPara/protected/admin/cadUserAdmin.jsp');");
				out.println("</script>");
			}
		}

	}
}
