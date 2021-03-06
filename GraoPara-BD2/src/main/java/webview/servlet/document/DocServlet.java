package webview.servlet.document;

import static webview.util.WebUtility.isInit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dto.UserAccount;
import webview.util.AlertsUtility;
import webview.util.WebUtility;
import business.EJB.documents.DocumentEJB;
import business.EJB.user.SearchUserBean;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;
import datatype.SimpleDate;

/**
 * Servlet implementation class DocServlet
 */
@WebServlet(urlPatterns={"/protected/admin/addDoc", "/protected/user/addDoc", "/protected/userAdv/addDoc"})
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoCodDocumento = request.getParameter("tipo_num");
		String codDocumento = request.getParameter("numero");		
		String local = request.getParameter("local");
		String url = request.getParameter("urlImagem");
		String resumo = request.getParameter("resumo");
		
		String[] identificacao = request.getParameter("identificacao").split("-");
		String tipoCodiceCaixa = identificacao[0];
		String codCodiceCaixa = identificacao[1];
		String tituloCodiceCaixa = identificacao[2];		
		String anoInicioCodiceCaixa = request.getParameter("anoInicioCodiceCaixa");
		String anoFimCodiceCaixa = request.getParameter("anoFimCodiceCaixa");
		
		String autor = request.getParameter("autor");
		String ocupacaoAutor = request.getParameter("autorOcupacao");
		
		String destinatario = request.getParameter("destinatario");
		String ocupacaoDestinatario = request.getParameter("destinatarioOcupacao");
		
		String tipoDocumento = request.getParameter("tipoDoc");
		
		String palavraChave1 = request.getParameter("chave1");
		String palavraChave2 = request.getParameter("chave2");
		String palavraChave3 = request.getParameter("chave3");
		
		Cookie c_user = WebUtility.selectCookie(
				request.getCookies(), WebUtility.cookie_email);
		String email = c_user.getValue();
		
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		String dia = request.getParameter("dia");
		String data = null;
		SimpleDate dataDoc = null;

		String descricaoDoTipoDocumento = null;
		
		UserAccount uploader = null;
		
		String c_status = null;
		
		if(request.getCookies().length > 1){
			try{
				c_status = WebUtility.selectCookie(request.getCookies(), WebUtility.cookie_status).getValue();
			} catch(NullPointerException e){
				c_status = null;
			}
		}
		
		if(tipoDocumento.contains("-")){
			descricaoDoTipoDocumento = tipoDocumento.split("-")[1];
			tipoDocumento = tipoDocumento.split("-")[0];
			descricaoDoTipoDocumento = descricaoDoTipoDocumento.trim();
			tipoDocumento = tipoDocumento.trim();
		}
		
		try {
			if(isInit(ano)) {
				data = ano;
				if(ano.length() < 4 || ano.equals("0000"))	throw new IllegalArgumentException("Ano inválido");
				if(isInit(mes) && !mes.equals("00"))  {
					data += "/" + mes;
					if(isInit(dia) && !dia.equals("00")) {
						data += "/" + dia;
					}
				}
				dataDoc = SimpleDate.parse(data);
			}
			
			uploader = (new SearchUserBean()).findUser(email);
			DocumentEJB CB = new DocumentEJB();
			codCodiceCaixa = tipoCodiceCaixa+"-"+codCodiceCaixa;
			try {
				CB.registerNewDocument(
						tipoCodDocumento,
						String.format("%04d", Integer.parseInt(codDocumento)), 
						local, 
						url,
						resumo, 
						dataDoc,
						uploader, 
						codCodiceCaixa, 
						tituloCodiceCaixa, 
						anoInicioCodiceCaixa, 
						anoFimCodiceCaixa, 
						autor, 
						ocupacaoAutor, 
						destinatario, 
						ocupacaoDestinatario, 
						tipoDocumento, 
						descricaoDoTipoDocumento, 
						palavraChave1,
						palavraChave2, 
						palavraChave3,
						c_status);
				AlertsUtility.alertAndRedirectHistory(response, "Documento adicionado com sucesso!");
			} catch (UnreachableDataBaseException e) {
				AlertsUtility.alertAndRedirectHistory(response, "Erro no banco de dados! Contate o suporte e tente novamente mais tarde.");
				e.printStackTrace();
			} catch (IllegalArgumentException e){
				e.printStackTrace();
				AlertsUtility.alertAndRedirectHistory(response, "Erro interno, tente novamente mais tarde.");
			}
		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnreachableDataBaseException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e){
			AlertsUtility.alertAndRedirectHistory(response, "Data inválido, verifique se a data esta correto e tente novamente.");
		}
	}
}
