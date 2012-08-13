package business.EJB.docEJB;

import business.DAO.documents.DocumentDAO;
import business.DAO.documents.DocumentTypeDAO;
import business.DAO.documents.IdNumDocumentoDAO;
import business.DAO.documents.KeyWordDAO;
import business.DAO.documents.OrigemDAO;

public class BuscaDocEJB {
	DocumentDAO docDao;
	KeyWordDAO kwDao;
	IdNumDocumentoDAO indDao;
	OrigemDAO origemDao;
	DocumentTypeDAO dtDao;
	
	public BuscaDocEJB() {
		docDao = new DocumentDAO();
		kwDao = new KeyWordDAO();
		indDao = new IdNumDocumentoDAO();
		origemDao = new OrigemDAO();
		dtDao = new DocumentTypeDAO();
	}
	
	public void busca(String identificacao, String codigo, String nomeDoDoc, 
			String numAPEP_SEQ, String autor, String destinatario, String Estado, 
			String cidade, String data, String tipo, String palavra1, String palavra2, String palavra3){
		
//		if(identificacao.equals("Número de Códice"))
		
	}
	
}
