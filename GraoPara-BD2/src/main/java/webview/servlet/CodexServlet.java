package webview.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webview.util.WebUtility;
import business.EJB.user.AuthBean;

/**
 * Servlet implementation class CodexServlet
 */
@WebServlet("/listCodex")
public class CodexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Lista de códices e/ou caixas com conteúdo: <br>");
		CodiceCaixaEJB cb = new CodiceCaixaEJB();
		try {
			List<DTO> list = cb.getAllEntriesWithContent();
			for(DTO d : list) {
				CodiceCaixa work = (CodiceCaixa) d;
				out.println("&#183" + work.getTitulo() + " - " + work.getAnoInicio() + "/" + work.getAnoFim() + "<br>");
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (CodiceCaixaNotFoundException e) {

		}*/
		
		
		
		String status = null;
		Cookie c_status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status);
		if(c_status != null && WebUtility.isInit(c_status.getValue())){
			status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();
			
			if(status.equals(AuthBean.LoginSuccessAdmin)){
				response.sendRedirect("/GraoPara/protected/admin/codCaixaList.jsp");
			}
			else if(status.equals(AuthBean.LoginSuccessUserLevel2)){
				response.sendRedirect("/GraoPara/protected/userAdv/codCaixaList.jsp");
			}
			else if(status.equals(AuthBean.LoginSuccessUserLevel1)){
				response.sendRedirect("/GraoPara/protected/user/codCaixaList.jsp");
			}
			else{
				response.sendRedirect("/GraoPara/public/codCaixaList.jsp");
			}
		}
		else{
			response.sendRedirect("/GraoPara/public/codCaixaList.jsp");		
		}
	}
}
