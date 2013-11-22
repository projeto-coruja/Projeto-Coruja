package webview.servlet.document;

import static webview.util.WebUtility.isInit;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.exceptions.UpdateEntityException;
import webview.util.AlertsUtility;
import webview.util.ParamsWrapper;
import business.EJB.documents.DocumentEJB;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import datatype.SimpleDate;

/**
 * Servlet implementation class DocUpdateServlet
 */
@WebServlet("/protected/admin/updateDoc")
public class DocUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocUpdateServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ParamsWrapper req = new ParamsWrapper(request);
    	
    	String tipoCodDocumentoAntigo = req.getParameter("pesquisa_APEP_SEQ");
		String codDocumentoAntigo = req.getParameter("pesquisa_num_APEP_SEQ");
		
		String tipoCodDocumento = req.getParameter("tipo_num");
		String codDocumento = req.getParameter("numero");
		String local = req.getParameter("local");
		String url = req.getParameter("urlImagem");
		String resumo = req.getParameter("resumo");
		
		String[] identificacao = req.getParameter("identificacao").split("-");
		String tipoCodiceCaixa = identificacao[0];
		String codCodiceCaixa = identificacao[1];
		
		String autor = req.getParameter("autor");
		String ocupacaoAutor = req.getParameter("autorOcupacao");
		
		String destinatario = req.getParameter("destinatario");
		String ocupacaoDestinatario = req.getParameter("destinatarioOcupacao");
		
		String tipoDocumento = req.getParameter("tipoDoc");
		
		String palavraChave1 = req.getParameter("chave1");
		String palavraChave2 = req.getParameter("chave2");
		String palavraChave3 = req.getParameter("chave3");
    			
	    String ano = req.getParameter("ano");
		String mes = req.getParameter("mes");
		String dia = req.getParameter("dia");
		String data = null;
		SimpleDate dataDoc = null;
		
		if(isInit(ano)) {
			data = ano;
			if(isInit(mes) && !mes.equals("00"))  {
				data += "/" + mes;
				if(isInit(dia) && !dia.equals("00")) {
					data += "/" + dia;
				}
			}
			dataDoc = SimpleDate.parse(data);
		}
		
		DocumentEJB CB = new DocumentEJB();
		codCodiceCaixa = tipoCodiceCaixa+"-"+codCodiceCaixa;
		/*codDocumento = tipoCodDocumento+"-"+codDocumento;*/
		
		try {
			CB.modifyDocument(tipoCodDocumentoAntigo,
					codDocumentoAntigo, 
					tipoCodDocumento,
					codDocumento,
					local, 
					url, 
					resumo, 
					dataDoc, 
					codCodiceCaixa, 
					autor, 
					ocupacaoAutor, 
					destinatario, 
					ocupacaoDestinatario, 
					tipoDocumento, 
					palavraChave1,
					palavraChave2, 
					palavraChave3);
			AlertsUtility.alertAndRedirectPage(response, "Documento Atualizado com sucesso!", "index.jsp");
		} catch (UnreachableDataBaseException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro no banco de dados! Contate o suporte e tente novamente mais tarde.");
			e.printStackTrace();
		} catch (DocumentNotFoundException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Erro interno, tente novamente mais tarde.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			AlertsUtility.alertAndRedirectHistory(response, "Número APEP/Sequencial duplicado!");
		} catch (UpdateEntityException e) {
			e.printStackTrace();
		}
    }
}

