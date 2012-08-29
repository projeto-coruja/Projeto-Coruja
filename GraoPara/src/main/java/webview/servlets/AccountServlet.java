package webview.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.UserDTO;
import webview.WebUtility;
import business.EJB.userEJB.AdminBean;
import business.EJB.userEJB.AuthBean;
import business.EJB.userEJB.BuscaUserEJB;
import business.EJB.userEJB.CadastroBean;
import business.EJB.util.EJBUtility;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Servlet implementation class AccoutRemoveServlet
 */
@WebServlet("/doChangesToAccount")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminBean adm = new AdminBean();
		String email = request.getParameter(EJBUtility.getHash("email", "SHA-256"));
		String action = request.getParameter(EJBUtility.getHash("action", "SHA-256"));
		String previous = request.getParameter("tab");
		
		try {
			if(action.equals(EJBUtility.getHash("approve", "SHA-256"))) adm.alterarPermissoesUsuario(email, "user");
			else if(action.equals(EJBUtility.getHash("delete", "SHA-256")))	adm.deletarUsuario(email);
		} catch (IncorrectProfileInformationException e) {
			e.printStackTrace();
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("/GraoPara/protected/admin/painelAdmin.jsp#tab"+previous);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroBean cadastro = new CadastroBean();
		BuscaUserEJB busca = new BuscaUserEJB();
		AdminBean admin = new AdminBean();
		String action = request.getParameter("action");
		String permissaoNova;
		String senhaVelha;
		String senhaNova;
		UserDTO user = null;
		String redirect = null;

		response.setContentType("text/html");  
		PrintWriter out=response.getWriter(); 

		String email = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_email).getValue();
		String status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();


		if(status.equals(AuthBean.LoginSuccessUser))	// retorna para a página de USER
			redirect = "/GraoPara/protected/user/painelUser.jsp";
		else if(status.equals(AuthBean.LoginSuccessAdmin))	// retorna para a página de ADMIN
			redirect = "/GraoPara/protected/admin/painelAdmin.jsp";
		
		if(action.equals("editPermission")){
			permissaoNova = request.getParameter("permissao");
			email = request.getParameter("email");
			out.println("<script>");  
			out.println("alert('Permissão trocada com sucesso. ');");  
			out.println("document.location=('" + redirect + "');");  
			out.println("</script>");
			try {
				admin.alterarPermissoesUsuario(email, permissaoNova);
			} catch (UnreachableDataBaseException e) {
			    out.println("<script>");  
			    out.println("alert('Não foi possível conectar com o banco de dados.');");  
			    out.println("document.location=('/GraoPara/public/index.jsp');");  
			    out.println("</script>");
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			} catch (IncorrectProfileInformationException e) {
				e.printStackTrace();
			} catch (ProfileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		else if(action.equals("editPassword")){
			senhaVelha = request.getParameter("senhaAtual");
			senhaNova = request.getParameter("senhaNova");
			try {
				user = busca.findUser(email);
				if(user.getPassword().equals(EJBUtility.getHash(senhaVelha, "MD5"))){
					user.setPassword(EJBUtility.getHash(senhaNova, "MD5"));
					cadastro.atualizarUsuario(user);  
					out.println("<script>");  
					out.println("alert('Senha trocada com sucesso. ');");  
					out.println("document.location=('" + redirect + "');");  
					out.println("</script>");
				}
				else{
					out.println("<script>");  
					out.println("alert('Erro ao trocar a senha, senha informada diferente da cadastrada. ');");  
					out.println("document.location=('" + redirect + "');");  
					out.println("</script>");
				}
			} catch (UnreachableDataBaseException e) {
			    out.println("<script>");  
			    out.println("alert('Não foi possível conectar com o banco de dados.');");  
			    out.println("document.location=('/GraoPara/public/index.jsp');");  
			    out.println("</script>");
				e.printStackTrace();
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}	
		}
	}

}
